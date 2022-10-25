package com.smart.inventory.domain.services;

import com.smart.inventory.domain.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO findProdutoById (Long id);

    ProdutoDTO insertProduto(ProdutoDTO obj);

    List<ProdutoDTO> findAllProdutos();

    void deleteProduto(Long id);

}
