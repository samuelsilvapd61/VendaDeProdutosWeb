package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe Repository de Cliente
 *
 * @author Samuel Silva
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

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
    List<Cliente> findByIdOrNomeCompletoOrCpfOrDataNascimentoOrGeneroOrEmailOrEnderecoOrTelefoneOrDataCadastro(
            long id,
            String nomeCompleto,
            String cpf,
            LocalDate dataNascimento,
            String genero,
            String email,
            String endereco,
            String telefone,
            LocalDateTime dataCadastro);
}
