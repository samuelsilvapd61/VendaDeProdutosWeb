package com.vendaprodutos.repository;

import com.vendaprodutos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

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
