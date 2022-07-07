package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe Repository de Pedido
 *
 * @author Samuel Silva
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    /**
     * Busca pedidos por parâmetros
     *
     * @param id ID de Pedido
     * @param dataCadastro Data de cadastro de Pedido
     * @param cliente ID de Cliente de Pedido
     * @return Lista de Pedido
     */
    List<Pedido> findByIdOrDataCadastroOrCliente(
            Long id,
            LocalDateTime dataCadastro,
            Cliente cliente);
}
