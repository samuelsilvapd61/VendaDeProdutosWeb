package com.vendaprodutos.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * Classe PostDTO da Categoria
 */
@Data
public class CategoriaPostDTO {
    private String nome;
}
