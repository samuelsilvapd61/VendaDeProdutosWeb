package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.Produto.ProdutoBuilder;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-29T13:12:27-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
@Component
public class ProdutoMapperImpl extends ProdutoMapper {

    @Override
    public Produto toProduto(ProdutoPutDTO produtoPutDTO) {
        if ( produtoPutDTO == null ) {
            return null;
        }

        ProdutoBuilder produto = Produto.builder();

        produto.id( produtoPutDTO.getId() );
        produto.nome( produtoPutDTO.getNome() );
        produto.descricao( produtoPutDTO.getDescricao() );
        produto.preco( produtoPutDTO.getPreco() );
        produto.categoria( produtoPutDTO.getCategoria() );

        return produto.build();
    }
}
