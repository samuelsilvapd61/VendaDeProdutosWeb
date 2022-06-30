package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.dto.CategoriaPostDTO;
import com.vendaprodutos.domain.dto.CategoriaPutDTO;
import com.vendaprodutos.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe para gerenciar rotas de categorias
 */
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    /**
     * Insere uma nova Categoria
     *
     * @param categoriaPostDTO
     */
    @ApiOperation(value = "Insere uma nova Categoria.")
    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody CategoriaPostDTO categoriaPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoriaPostDTO));
    }

    /**
     * Busca todos as categorias
     */
    @ApiOperation(value = "Busca todos as categorias.")
    @GetMapping
    public ResponseEntity<List<Categoria>> list() {
        return ResponseEntity.ok(categoriaService.listAll());
    }

    /**
     * Busca uma categoria por id
     *
     * @param id
     */
    @ApiOperation(value = "Busca uma categoria por id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    /**
     * Busca uma categoria por parâmetros
     *
     * @param id
     * @param nome

     */
    @ApiOperation(value = "Busca uma categoria por parâmetros.")
    @GetMapping(path = "/find")
    public ResponseEntity<List<Categoria>> findByParameter(
            @RequestParam(required = false, defaultValue = "0") Long id,
            @RequestParam(required = false) String nome) {

        List<Categoria> lista = categoriaService.findByParameter(id, nome);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca todas as categorias, mas de forma paginada
     * É interessante usar os parâmetros "size", "page" e "sort"
     * @param pageable
     */
    @ApiOperation(value = "Busca todas as categorias, mas de forma paginada." +
            " É interessante usar os parâmetros \"size\", \"page\" e \"sort.")
    @GetMapping(path = "/page")
    public ResponseEntity<Page<Categoria>> listPage(Pageable pageable) {
        return ResponseEntity.ok(categoriaService.listPage(pageable));
    }

    /**
     * Altera uma categoria por id
     *
     * @param categoriaPutDTO
     */
    @ApiOperation(value = "Altera uma categoria por id.")
    @PutMapping
    public ResponseEntity<Categoria> updateById(@RequestBody CategoriaPutDTO categoriaPutDTO) {
        return ResponseEntity.ok(categoriaService.update(categoriaPutDTO));
    }

    /**
     * Apaga uma categoria por id
     *
     * @param id
     */
    @ApiOperation(value = "Apaga uma categoria por id.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
