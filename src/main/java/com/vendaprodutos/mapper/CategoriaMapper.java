package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.dto.CategoriaPostDTO;
import com.vendaprodutos.domain.dto.CategoriaPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Classe de mapeamento de Categoria
 *
 * @author Samuel Silva
 */
@Mapper(componentModel = "spring")
public abstract class CategoriaMapper {

    /**
     * INSTANCE
     */
    public static final CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    /**
     * Passa os atributos de CategoriaPostDTO para um objeto Categoria
     *
     * @param categoriaPostDTO CategoriaPostDTO
     * @return Categoria
     */
    public abstract Categoria toCategoria(CategoriaPostDTO categoriaPostDTO);

    /**
     * Passa os atributos de CategoriaPutDTO para um objeto Categoria
     *
     * @param categoriaPutDTO CategoriaPutDTO
     * @return Categoria
     */
    public abstract Categoria toCategoria(CategoriaPutDTO categoriaPutDTO);
}
