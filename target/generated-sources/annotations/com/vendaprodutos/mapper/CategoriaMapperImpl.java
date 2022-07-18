package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Categoria.CategoriaBuilder;
import com.vendaprodutos.domain.dto.CategoriaPostDTO;
import com.vendaprodutos.domain.dto.CategoriaPutDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-12T10:19:44-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1 (Azul Systems, Inc.)"
)
@Component
public class CategoriaMapperImpl extends CategoriaMapper {

    @Override
    public Categoria toCategoria(CategoriaPostDTO categoriaPostDTO) {
        if ( categoriaPostDTO == null ) {
            return null;
        }

        CategoriaBuilder categoria = Categoria.builder();

        categoria.nome( categoriaPostDTO.getNome() );

        return categoria.build();
    }

    @Override
    public Categoria toCategoria(CategoriaPutDTO categoriaPutDTO) {
        if ( categoriaPutDTO == null ) {
            return null;
        }

        CategoriaBuilder categoria = Categoria.builder();

        categoria.id( categoriaPutDTO.getId() );
        categoria.nome( categoriaPutDTO.getNome() );

        return categoria.build();
    }
}
