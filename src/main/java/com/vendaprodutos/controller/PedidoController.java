package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
import com.vendaprodutos.service.PedidoService;
import com.vendaprodutos.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe para gerenciar rotas de pedidos
 */
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    /**
     * Insere um novo Pedido
     *
     * @param pedidoPostDTO
     */
    @ApiOperation(value = "Insere um novo Pedido.")
    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoPostDTO pedidoPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoPostDTO));
    }

    /**
     * Busca todos os pedidos
     */
    @ApiOperation(value = "Busca todos os pedidos.")
    @GetMapping
    public ResponseEntity<List<Pedido>> list() {
        return ResponseEntity.ok(pedidoService.listAll());
    }
}
