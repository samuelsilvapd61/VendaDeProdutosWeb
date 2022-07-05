package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Pedido.PedidoBuilder;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-05T12:35:34-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
@Component
public class PedidoMapperImpl extends PedidoMapper {

    @Override
    public Pedido toPedido(ProdutoPutDTO produtoPutDTO) {
        if ( produtoPutDTO == null ) {
            return null;
        }

        PedidoBuilder pedido = Pedido.builder();

        pedido.id( produtoPutDTO.getId() );

        return pedido.build();
    }
}
