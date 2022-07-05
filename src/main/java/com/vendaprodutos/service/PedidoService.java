package com.vendaprodutos.service;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.domain.dto.PedidoPutDTO;
import com.vendaprodutos.mapper.PedidoMapper;
import com.vendaprodutos.mapper.ProdutoMapper;
import com.vendaprodutos.repository.PedidoRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public Pedido save(PedidoPostDTO pedidoPostDTO) {
        Pedido pedido = PedidoMapper.INSTANCE.toPedido(pedidoPostDTO);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(long id) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }

    public List<Pedido> findByParameter(Long id, LocalDateTime dataCadastro, Cliente cliente) {
        return pedidoRepository.findByIdOrDataCadastroOrCliente(id, dataCadastro, cliente);
    }

    public Page<Pedido> listPage(Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    public Pedido update(PedidoPutDTO pedidoPutDTO) {
        Pedido savedPedido = findById(pedidoPutDTO.getId());
        Pedido pedido = PedidoMapper.INSTANCE.toPedido(pedidoPutDTO);
        pedido.setId(savedPedido.getId()); // Garantir que o id está correto
        pedido.setDataCadastro(savedPedido.getDataCadastro()); // Preencher a dataCadastro
        return pedidoRepository.save(pedido);
    }

    public void delete(long id) {
        pedidoRepository.delete(findById(id));
    }
}
