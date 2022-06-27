package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {
    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public abstract Cliente toCliente(ClientePostDTO clientePostDTO);

    // Criei esse método para conseguir preencher o campo Cliente.dataCadastro,
    // porque o ClientePostDTO não tem esse campo
    // Se eu descobrir uma forma melhor de resolver essa questão, eu vou mudar essa solução
    public Cliente toClientePost(ClientePostDTO clientePostDTO) {
        Cliente cliente = toCliente(clientePostDTO);
        cliente.novaDataCadastro();
        return cliente;
    }
    public abstract Cliente toCliente(ClientePutDTO clientePutDTO);
}
