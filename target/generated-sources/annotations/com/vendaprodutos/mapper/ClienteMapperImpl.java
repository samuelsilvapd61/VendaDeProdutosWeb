package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Cliente.ClienteBuilder;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-27T16:54:21-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
@Component
public class ClienteMapperImpl extends ClienteMapper {

    @Override
    public Cliente toCliente(ClientePutDTO clientePutDTO) {
        if ( clientePutDTO == null ) {
            return null;
        }

        ClienteBuilder cliente = Cliente.builder();

        cliente.id( clientePutDTO.getId() );
        cliente.nomeCompleto( clientePutDTO.getNomeCompleto() );
        cliente.cpf( clientePutDTO.getCpf() );
        cliente.dataNascimento( clientePutDTO.getDataNascimento() );
        cliente.genero( clientePutDTO.getGenero() );
        cliente.email( clientePutDTO.getEmail() );
        cliente.endereco( clientePutDTO.getEndereco() );
        cliente.telefone( clientePutDTO.getTelefone() );

        return cliente.build();
    }
}
