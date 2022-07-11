package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Item;
import com.vendaprodutos.domain.Pedido;
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

}
