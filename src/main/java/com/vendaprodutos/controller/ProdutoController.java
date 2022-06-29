package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ProdutoPostDTO;
import com.vendaprodutos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe para gerenciar rotas de produtos
 */
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    /**
     * Insere um novo Cliente
     *
     * @param produtoPostDTO
     */
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoPostDTO produtoPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoPostDTO));
    }

    /**
     * Busca todos os produtos
     */
    @GetMapping
    public ResponseEntity<List<Produto>> list() {
        return ResponseEntity.ok(produtoService.listAll());
    }

    /**
     * Busca um produto por id
     *
     * @param id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }
}
