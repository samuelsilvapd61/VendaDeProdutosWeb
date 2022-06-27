package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Categoria.CategoriaBuilder;
import com.vendaprodutos.domain.dto.CategoriaPostDTO;
import com.vendaprodutos.domain.dto.CategoriaPutDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-27T16:31:55-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
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
