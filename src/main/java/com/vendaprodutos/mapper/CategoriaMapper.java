package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.dto.CategoriaPostDTO;
import com.vendaprodutos.domain.dto.CategoriaPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CategoriaMapper {
    public static final CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    public abstract Categoria toCategoria(CategoriaPostDTO categoriaPostDTO);
    public abstract Categoria toCategoria(CategoriaPutDTO categoriaPutDTO);
}
