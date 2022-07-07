package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Classe Repository de Categoria
 *
 * @author Samuel Silva
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    /**
     * Busca categorias por parâmetros
     *
     * @param id ID de Categoria
     * @param nome Nome de Categoria
     * @return Lista de Categoria
     */
    List<Categoria> findByIdOrNome(Long id, String nome);

}
