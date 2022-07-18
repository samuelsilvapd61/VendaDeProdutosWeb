package com.vendaprodutos.domain.dto;

import lombok.Data;

/**
 * Classe PostDTO do Item
 */
@Data
public class ItemPostDTO {
    private Integer quantidade;
    private Long pedidoId;
    private Long produtoId;
}
