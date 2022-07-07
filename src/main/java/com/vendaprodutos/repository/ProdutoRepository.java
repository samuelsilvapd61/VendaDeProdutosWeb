package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe Repository de Produto
 *
 * @author Samuel Silva
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /**
     * Busca produtos por parâmetros
     *
     * @param id ID de Produto
     * @param nome Nome de Produto
     * @param descricao Descrição de Produto
     * @param preco Preço de Produto
     * @param dataCadastro Data de cadastro de Produto
     * @param categoria ID de Categoria de Produto
     * @return Lista de Produto
     */
    List<Produto> findByIdOrNomeOrDescricaoOrPrecoOrDataCadastroOrCategoria(
            Long id,
            String nome,
            String descricao,
            Double preco,
            LocalDateTime dataCadastro,
            Categoria categoria);
}
