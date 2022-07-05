package com.vendaprodutos.domain.dto;

import lombok.Data;

@Data
public class ProdutoPutDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Long categoriaId;
}
