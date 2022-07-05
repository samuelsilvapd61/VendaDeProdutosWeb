package com.vendaprodutos.domain.dto;

import com.vendaprodutos.domain.Cliente;
import lombok.Data;

@Data
public class PedidoPutDTO {
    private Long id;
    private Long clienteId;
}
