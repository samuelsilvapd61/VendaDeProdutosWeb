package com.vendaprodutos.service;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.mapper.PedidoMapper;
import com.vendaprodutos.repository.PedidoRepository;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
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
}
