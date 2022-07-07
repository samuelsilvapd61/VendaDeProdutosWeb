package com.vendaprodutos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


/**
 * Domain Cliente
 *
 * @author Samuel Silva
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime dataCadastro = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

}
