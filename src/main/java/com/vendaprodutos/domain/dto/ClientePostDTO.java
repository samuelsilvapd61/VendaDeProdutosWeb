package com.vendaprodutos.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientePostDTO {
    private String nomeCompleto;
    private String cpf;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataNascimento;
    private String genero;
    private String email;
    private String endereco;
    private String telefone;
}
