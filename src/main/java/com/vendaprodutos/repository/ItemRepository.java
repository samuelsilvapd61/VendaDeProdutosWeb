package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Item;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe Repository de Item
 *
 * @author Samuel Silva
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Busca um produto por parâmetros
     *
     * @param id ID do Pedido
     * @param quantidade quantidade do item em questão
     * @param produto ID do Produto do Item
     * @param pedido ID do Pedido do Item
     * @return Lista de Item
     */
    List<Item> findByIdOrQuantidadeOrProdutoOrPedido(
            Long id,
            Integer quantidade,
            Produto produto,
            Pedido pedido);
}
