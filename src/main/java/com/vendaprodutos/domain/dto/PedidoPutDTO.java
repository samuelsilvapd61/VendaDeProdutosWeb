package com.vendaprodutos.domain.dto;

import lombok.Data;

/**
 * Classe PutDTO do Pedido
 */
@Data
public class PedidoPutDTO {
    private Long id;
    private Long clienteId;
}
