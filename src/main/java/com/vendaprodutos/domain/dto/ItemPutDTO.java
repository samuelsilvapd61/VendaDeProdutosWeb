package com.vendaprodutos.domain.dto;

import lombok.Data;

/**
 * Classe PutDTO do Item
 */
@Data
public class ItemPutDTO {
    private Long id;
    private Integer quantidade;
    private Long pedidoId;
    private Long produtoId;
}
