package com.vendaprodutos.service;

import com.vendaprodutos.domain.Cliente;
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
    public Cliente save(Cliente cliente) {
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

    public Cliente update(Cliente cliente) {
        Cliente savedCliente = findById(cliente.getId());
        Cliente clienteUpdate = Cliente.builder()
                .id(savedCliente.getId())
                .nomeCompleto(cliente.getNomeCompleto())
                .cpf(cliente.getCpf())
                .dataNascimento(cliente.getDataNascimento())
                .genero(cliente.getGenero())
                .email(cliente.getEmail())
                .endereco(cliente.getEndereco())
                .telefone(cliente.getTelefone())
                .dataCadastro(savedCliente.getDataCadastro())
                .build();

        return clienteRepository.save(clienteUpdate);
    }
}
