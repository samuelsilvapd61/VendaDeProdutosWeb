package com.vendaprodutos.domain.dto;

import lombok.Data;

/**
 * Classe PostDTO do Produto
 */
@Data
public class ProdutoPostDTO {
    private String nome;
    private String descricao;
    private Double preco;
    private Long categoriaId;
}
