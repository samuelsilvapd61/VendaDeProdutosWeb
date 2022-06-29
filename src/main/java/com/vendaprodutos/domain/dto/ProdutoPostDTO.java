package com.vendaprodutos.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vendaprodutos.domain.Categoria;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
public class ProdutoPostDTO {
    private String nome;
    private String descricao;
    private Double preco;
    private Categoria categoria;
}
