package com.vendaprodutos.service;

import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.mapper.PedidoMapper;
import com.vendaprodutos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
