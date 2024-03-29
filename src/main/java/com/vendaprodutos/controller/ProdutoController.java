package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.ProdutoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
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
 * Classe para gerenciar rotas de produtos
 *
 * @author Samuel Silva
 */
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    /**
     * Insere um novo Produto
     *
     * @param produtoPostDTO Corpo PostDTO de Produto
     * @return Produto
     */
    @ApiOperation(value = "Insere um novo Produto.")
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoPostDTO produtoPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produtoPostDTO));
    }

    /**
     * Busca todos os produtos
     *
     * @return Lista de Produto
     */
    @ApiOperation(value = "Busca todos os produtos.")
    @GetMapping
    public ResponseEntity<List<Produto>> list() {
        return ResponseEntity.ok(produtoService.listAll());
    }

    /**
     * Busca um produto por id
     *
     * @param id ID do Produto
     * @return Produto
     */
    @ApiOperation(value = "Busca um produto por id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    /**
     * Busca um produto por parâmetros
     *
     * @param id ID do Produto
     * @param nome Nome do Produto
     * @param descricao Descrição do Produto
     * @param preco Preço do Produto
     * @param dataCadastro Data de Cadastro do Produto
     * @param categoria ID de Categoria de Produto
     * @return Lista de Produto
     */
    @ApiOperation(value = "Busca um produto por parâmetros.")
    @GetMapping(path = "/find")
    public ResponseEntity<List<Produto>> findByParameter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) Double preco,
            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
            @Pattern(regexp = "([0-9]{4}[/][0-1][0-9][/][0-3][0-9][ ][0-2][0-9][:][0-5][0-9])")
            @RequestParam(required = false) LocalDateTime dataCadastro,
            @RequestParam(name = "categoriaId", required = false) Categoria categoria) {

        List<Produto> lista = produtoService.findByParameter(id, nome, descricao, preco, dataCadastro, categoria);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca todos os produtos, mas de forma paginada
     * É interessante usar os parâmetros "size", "page" e "sort"
     *
     * @param pageable Pageable
     * @return Page de Produto
     */
    @ApiOperation(value = "Busca todos os produtos, mas de forma paginada." +
            " É interessante usar os parâmetros \"size\", \"page\" e \"sort\"")
    @GetMapping(path = "/page")
    public ResponseEntity<Page<Produto>> listPage(Pageable pageable) {
        return ResponseEntity.ok(produtoService.listPage(pageable));
    }

    /**
     * Altera um produto por id
     *
     * @param produtoPutDTO Corpo PutDTO de Produto
     * @return Produto
     */
    @ApiOperation(value = "Altera um produto por id.")
    @PutMapping
    public ResponseEntity<Produto> updateById(@RequestBody ProdutoPutDTO produtoPutDTO) {
        return ResponseEntity.ok(produtoService.update(produtoPutDTO));
    }

    /**
     * Apaga um produto por id
     *
     * @param id ID do Produto
     * @return VAZIO
     */
    @ApiOperation(value = "Apaga um produto por id.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
