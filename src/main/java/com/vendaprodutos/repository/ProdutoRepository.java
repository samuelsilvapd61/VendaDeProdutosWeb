package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByIdOrNomeOrDescricaoOrPrecoOrDataCadastroOrCategoria(
            Long id,
            String nome,
            String descricao,
            Double preco,
            LocalDateTime dataCadastro,
            Categoria categoria);
}
