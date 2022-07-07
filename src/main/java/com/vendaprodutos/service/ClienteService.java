package com.vendaprodutos.service;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import com.vendaprodutos.mapper.ClienteMapper;
import com.vendaprodutos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Classe Service de Cliente
 *
 * @author Samuel Silva
 */
@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    /**
     * Adiciona um Cliente ao banco de dados
     *
     * @param clientePostDTO ClientePostDTO
     * @return Cliente
     */
    @Transactional
    public Cliente save(ClientePostDTO clientePostDTO) {
        Cliente cliente = ClienteMapper.INSTANCE.toCliente(clientePostDTO);
        return clienteRepository.save(cliente);
    }

    /**
     * Lista todos os clientes
     *
     * @return Lista de Produto
     */
    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    /**
     * Busca um cliente por ID
     *
     * @param id ID do Cliente
     * @return Cliente
     */
    public Cliente findById(long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }


    /**
     * Apaga um cliente por id no banco de dados
     *
     * @param id ID do Cliente
     */
    public void delete(long id) {
        clienteRepository.delete(findById(id));
    }

    /**
     * Altera um cliente por id no banco de dados
     *
     * @param clientePutDTO Corpo PutDTO de Cliente
     * @return Cliente
     */
    public Cliente update(ClientePutDTO clientePutDTO) {
        Cliente savedCliente = findById(clientePutDTO.getId());
        Cliente cliente = ClienteMapper.INSTANCE.toCliente(clientePutDTO);
        cliente.setId(savedCliente.getId()); // Garantir que o id está correto
        cliente.setDataCadastro(savedCliente.getDataCadastro()); // Preencher a dataCadastro
        return clienteRepository.save(cliente);
    }

    /**
     * Busca clientes por parâmetros
     *
     * @param id ID de Cliente
     * @param nomeCompleto Nome Completo de Cliente
     * @param cpf CPF de Cliente
     * @param dataNascimento Data de nascimento de Cliente
     * @param genero Gênero de Cliente
     * @param email Email de Cliente
     * @param endereco Endereço de Cliente
     * @param telefone Telefone de Cliente
     * @param dataCadastro Data de Cadastro de Cliente
     * @return Lista de Cliente
     */
    public List<Cliente> findByParameter(long id, String nomeCompleto, String cpf, LocalDate dataNascimento,
                                         String genero, String email, String endereco, String telefone,
                                         LocalDateTime dataCadastro) {
        return clienteRepository.findByIdOrNomeCompletoOrCpfOrDataNascimentoOrGeneroOrEmailOrEnderecoOrTelefoneOrDataCadastro(
                id, nomeCompleto, cpf, dataNascimento, genero, email, endereco, telefone, dataCadastro
        );
    }

    /**
     * Busca todos os clientes, mas de forma paginada
     *
     * @param pageable Pageable
     * @return Page de Cliente
     */
    public Page<Cliente> listPage(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }
}
