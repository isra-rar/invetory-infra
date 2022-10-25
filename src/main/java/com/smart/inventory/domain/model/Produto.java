package com.smart.inventory.domain.model;

import com.smart.inventory.domain.dto.ProdutoDTO;
import com.smart.inventory.domain.enums.Empresa;
import com.smart.inventory.domain.enums.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Produto extends BaseEntity {

    public Produto(ProdutoDTO produtoDTO) {
        this.descricao = produtoDTO.getDescricao();
        this.preco = produtoDTO.getPreco();
        this.quatidade = produtoDTO.getQuatidade();
        this.tipoProduto = produtoDTO.getTipoProduto();
        this.empresa = produtoDTO.getEmpresa();
    }

    private String descricao;
    private double preco;
    private int quatidade;

    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;

    @Enumerated(EnumType.STRING)
    private Empresa empresa;


}
