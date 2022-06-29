package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import com.vendaprodutos.domain.dto.ProdutoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
import com.vendaprodutos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    /**
     * Busca um cliente por parâmetros
     *
     * @param id
     * @param nome
     * @param descricao
     * @param preco
     * @param dataCadastro
     */
    @GetMapping(path = "/find")
    public ResponseEntity<List<Produto>> findByParameter(
            @RequestParam(required = false, defaultValue = "0") Long id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) Double preco,
            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm") @RequestParam(required = false) LocalDateTime dataCadastro,
            @RequestParam(name = "categoriaId", required = false) Categoria categoria) {

        List<Produto> lista = produtoService.findByParameter(id, nome, descricao, preco, dataCadastro, categoria);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca todos os produtos, mas de forma paginada
     * É interessante usar os parâmetros "size", "page" e "sort"
     * @param pageable
     */
    @GetMapping(path = "/page")
    public ResponseEntity<Page<Produto>> listPage(Pageable pageable) {
        return ResponseEntity.ok(produtoService.listPage(pageable));
    }

    /**
     * Altera um produto por id
     *
     * @param produtoPutDTO
     */
    @PutMapping
    public ResponseEntity<Produto> updateById(@RequestBody ProdutoPutDTO produtoPutDTO) {
        return ResponseEntity.ok(produtoService.update(produtoPutDTO));
    }

    /**
     * Apaga um produto por id
     *
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
