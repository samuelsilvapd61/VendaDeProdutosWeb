package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {
    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public Cliente toCliente(ClientePostDTO clientePostDTO) {
        if ( clientePostDTO == null ) {
            return null;
        }

        Cliente.ClienteBuilder cliente = Cliente.builder();

        cliente.nomeCompleto( clientePostDTO.getNomeCompleto() );
        cliente.cpf( clientePostDTO.getCpf() );
        cliente.dataNascimento( clientePostDTO.getDataNascimento() );
        cliente.genero( clientePostDTO.getGenero() );
        cliente.email( clientePostDTO.getEmail() );
        cliente.endereco( clientePostDTO.getEndereco() );
        cliente.telefone( clientePostDTO.getTelefone() );
        cliente.dataCadastro(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));

        return cliente.build();
    }

    public abstract Cliente toCliente(ClientePutDTO clientePutDTO);
}
