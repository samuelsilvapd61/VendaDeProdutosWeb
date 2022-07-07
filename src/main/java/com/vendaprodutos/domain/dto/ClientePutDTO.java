package com.vendaprodutos.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * Classe PutDTO do Cliente
 */
@Data
public class ClientePutDTO {
    private Long id;
    private String nomeCompleto;
    @Pattern(regexp = "([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[-][0-9]{2})")
    private String cpf;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataNascimento;
    private String genero;
    private String email;
    private String endereco;
    private String telefone;
}
