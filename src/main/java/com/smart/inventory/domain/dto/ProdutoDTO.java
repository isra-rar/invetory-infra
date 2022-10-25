package com.smart.inventory.domain.dto;

import com.smart.inventory.domain.enums.Empresa;
import com.smart.inventory.domain.enums.TipoProduto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoDTO {

    private Long id;
    private String descricao;
    private double preco;
    private int quatidade;
    private TipoProduto tipoProduto;
    private Empresa empresa;

}
