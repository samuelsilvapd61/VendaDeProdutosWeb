package com.vendaprodutos.service;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.domain.dto.PedidoPutDTO;
import com.vendaprodutos.mapper.PedidoMapper;
import com.vendaprodutos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Classe Service de Pedido
 *
 * @author Samuel Silva
 */
@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    /**
     * Adiciona um Pedido ao banco de dados
     *
     * @param pedidoPostDTO PedidoPostDTO
     * @return Pedido
     */
    public Pedido save(PedidoPostDTO pedidoPostDTO) {
        Pedido pedido = PedidoMapper.INSTANCE.toPedido(pedidoPostDTO);
        return pedidoRepository.save(pedido);
    }

    /**
     * Lista todos os pedidos
     *
     * @return Lista de Produto
     */
    public List<Pedido> listAll() {
        return pedidoRepository.findAll();
    }

    /**
     * Busca um Pedido por ID
     *
     * @param id ID de Pedido
     * @return Pedido
     */
    public Pedido findById(long id) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }

    /**
     * Busca pedidos por parâmetros
     *
     * @param id ID de Pedido
     * @param dataCadastro Data de cadastro de Pedido
     * @param cliente ID de Cliente de Pedido
     * @return Lista de Pedido
     */
    public List<Pedido> findByParameter(Long id, LocalDateTime dataCadastro, Cliente cliente) {
        return pedidoRepository.findByIdOrDataCadastroOrCliente(id, dataCadastro, cliente);
    }

    /**
     * Busca todos os pedidos, mas de forma paginada
     *
     * @param pageable Pageable
     * @return Page de Pedido
     */
    public Page<Pedido> listPage(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    /**
     * Altera um pedido por id no banco de dados
     *
     * @param pedidoPutDTO Corpo PutDTO de Pedido
     * @return Pedido
     */
    public Pedido update(PedidoPutDTO pedidoPutDTO) {
        Pedido savedPedido = findById(pedidoPutDTO.getId());
        Pedido pedido = PedidoMapper.INSTANCE.toPedido(pedidoPutDTO);
        pedido.setId(savedPedido.getId()); // Garantir que o id está correto
        pedido.setDataCadastro(savedPedido.getDataCadastro()); // Preencher a dataCadastro
        return pedidoRepository.save(pedido);
    }

    /**
     * Apaga um pedido por id no banco de dados
     *
     * @param id ID do Pedido
     */
    public void delete(long id) {
        pedidoRepository.delete(findById(id));
    }
}
