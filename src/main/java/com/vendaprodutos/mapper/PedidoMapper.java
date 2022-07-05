package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public abstract class PedidoMapper {
    public static final PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    //public abstract Pedido toPedido(PedidoPostDTO pedidoPostDTO);
    public Pedido toPedido(PedidoPostDTO pedidoPostDTO) {
        if ( pedidoPostDTO == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();
        pedido.cliente( Cliente.builder().id(pedidoPostDTO.getClienteId()).build());
        pedido.dataPedido(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

        return pedido.build();
    }

    public abstract Pedido toPedido(ProdutoPutDTO produtoPutDTO);
}
