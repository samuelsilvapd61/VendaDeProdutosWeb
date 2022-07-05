package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByIdOrDataCadastroOrCliente(
            Long id,
            LocalDateTime dataCadastro,
            Cliente cliente);
}
