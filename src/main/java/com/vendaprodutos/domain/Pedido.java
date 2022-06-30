package com.vendaprodutos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime dataCadastro = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    //private Double valorTotal;
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
}
