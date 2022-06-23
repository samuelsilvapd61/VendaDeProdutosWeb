package com.vendaprodutos.service;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import com.vendaprodutos.mapper.ClienteMapper;
import com.vendaprodutos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Transactional
    public Cliente save(ClientePostDTO clientePostDTO) {
        Cliente cliente = ClienteMapper.INSTANCE.toClientePost(clientePostDTO);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }

    public void delete(long id) {
        clienteRepository.delete(findById(id));
    }

    public Cliente update(ClientePutDTO clientePutDTO) {
        Cliente savedCliente = findById(clientePutDTO.getId());
        Cliente cliente = ClienteMapper.INSTANCE.toCliente(clientePutDTO);
        cliente.setId(savedCliente.getId()); // Garantir que o id está correto
        cliente.setDataCadastro(savedCliente.getDataCadastro()); // Preencher a dataCadastro
        return clienteRepository.save(cliente);
    }
}
