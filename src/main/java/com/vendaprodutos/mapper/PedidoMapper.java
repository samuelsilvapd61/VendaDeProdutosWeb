package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.domain.dto.PedidoPutDTO;
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
        pedido.dataCadastro(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

        return pedido.build();
    }

    public Pedido toPedido(PedidoPutDTO pedidoPutDTO) {
        if ( pedidoPutDTO == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.id( pedidoPutDTO.getId() );
        pedido.cliente( Cliente.builder().id(pedidoPutDTO.getClienteId()).build() );

        return pedido.build();
    }
}
