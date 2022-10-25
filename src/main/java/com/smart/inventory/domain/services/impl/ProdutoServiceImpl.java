package com.smart.inventory.domain.services.impl;

import com.smart.inventory.domain.dto.ProdutoDTO;
import com.smart.inventory.domain.model.Produto;
import com.smart.inventory.domain.repositories.ProdutoRepository;
import com.smart.inventory.domain.services.ProdutoService;
import com.smart.inventory.domain.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProdutoDTO findProdutoById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        produto.orElseThrow(() -> new ResourceNotFoundException(id));
        return toProdutoDTO(produto.get());
    }

    @Override
    public ProdutoDTO insertProduto(ProdutoDTO obj) {
        Produto produto = toProduto(obj);
        produtoRepository.save(produto);
        return toProdutoDTO(produto);
    }

    @Override
    public List<ProdutoDTO> findAllProdutos() {
        List<Produto> produtoList = produtoRepository.findAll();
        return toProdutoListDTO(produtoList);
    }

    @Override
    public void deleteProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        produtoRepository.delete(produto.get());
    }

    private Produto toProduto(ProdutoDTO produtoDTO) {
        return new Produto(produtoDTO);
    }

    private ProdutoDTO toProdutoDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    private List<ProdutoDTO> toProdutoListDTO(List<Produto> produtoList) {
        return mapList(produtoList, ProdutoDTO.class);
    }

    private <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
