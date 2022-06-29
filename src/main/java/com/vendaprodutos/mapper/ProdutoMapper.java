package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import com.vendaprodutos.domain.dto.ProdutoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public abstract class ProdutoMapper {
    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    public Produto toProduto(ProdutoPostDTO produtoPostDTO) {
        if ( produtoPostDTO == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setNome( produtoPostDTO.getNome() );
        produto.setDescricao( produtoPostDTO.getDescricao() );
        produto.setPreco( produtoPostDTO.getPreco() );
        produto.setCategoria( produtoPostDTO.getCategoria() );
        produto.setDataCadastro(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

        return produto;
    }
    public abstract Produto toProduto(ProdutoPutDTO produtoPutDTO);
}
