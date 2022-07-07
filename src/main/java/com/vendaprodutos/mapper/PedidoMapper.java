package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.domain.dto.PedidoPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Classe de mapeamento de Pedido
 *
 * @author Samuel Silva
 */
@Mapper(componentModel = "spring")
public abstract class PedidoMapper {

    /**
     * INSTANCE
     */
    public static final PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    /**
     * Passa os atributos de PedidoPostDTO para um objeto Pedido
     *
     * @param pedidoPostDTO PedidoPostDTO
     * @return Pedido
     */
    public Pedido toPedido(PedidoPostDTO pedidoPostDTO) {
        if ( pedidoPostDTO == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();
        pedido.cliente( Cliente.builder().id(pedidoPostDTO.getClienteId()).build());
        pedido.dataCadastro(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

        return pedido.build();
    }

    /**
     * Passa os atributos de PedidoPutDTO para um objeto Pedido
     *
     * @param pedidoPutDTO PedidoPutDTO
     * @return Pedido
     */
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
