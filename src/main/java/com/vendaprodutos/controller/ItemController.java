package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Item;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.ItemPostDTO;
import com.vendaprodutos.domain.dto.ItemPutDTO;
import com.vendaprodutos.domain.dto.PedidoPutDTO;
import com.vendaprodutos.service.ItemService;
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
 * Classe para gerenciar rotas de itens
 *
 * @author Samuel Silva
 */
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("itens")
public class ItemController {

    private final ItemService itemService;

    /**
     * Insere um novo Item
     *
     * @param itemPostDTO Corpo PostDTO de Item
     * @return Item
     */
    @ApiOperation(value = "Insere um novo Item.")
    @PostMapping
    public ResponseEntity<Item> save(@RequestBody ItemPostDTO itemPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(itemPostDTO));
    }

    /**
     * Busca um Item por id
     *
     * @param id ID do Item
     * @return Item
     */
    @ApiOperation(value = "Busca um item por id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Item> findById(@PathVariable long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    /**
     * Busca todos os itens
     *
     * @return Lista de Item
     */
    @ApiOperation(value = "Busca todos os itens.")
    @GetMapping
    public ResponseEntity<List<Item>> list() {
        return ResponseEntity.ok(itemService.listAll());
    }

    /**
     * Busca um item por parâmetros
     *
     * @param id ID do Pedido
     * @param quantidade quantidade do item em questão
     * @param produto ID do Produto do Item
     * @param pedido ID do Pedido do Item
     * @return Lista de Item
     */
    @ApiOperation(value = "Busca um item por parâmetros.")
    @GetMapping(path = "/find")
    public ResponseEntity<List<Item>> findByParameter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) Integer quantidade,
            @RequestParam(name = "produtoId", required = false) Produto produto,
            @RequestParam(name = "pedidoId", required = false) Pedido pedido) {

        List<Item> lista = itemService.findByParameter(id, quantidade, produto, pedido);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca todos os itens, mas de forma paginada
     * É interessante usar os parâmetros "size", "page" e "sort"
     *
     * @param pageable Pageable
     * @return Page de Pedido
     */
    @ApiOperation(value = "Busca todos os itens, mas de forma paginada." +
            " É interessante usar os parâmetros \"size\", \"page\" e \"sort\"")
    @GetMapping(path = "/page")
    public ResponseEntity<Page<Item>> listPage(Pageable pageable) {
        return ResponseEntity.ok(itemService.listPage(pageable));
    }

    /**
     * Altera um Item por id
     *
     * @param itemPutDTO Corpo PutDTO de Item
     * @return Item
     */
    @ApiOperation(value = "Altera um Item por id.")
    @PutMapping
    public ResponseEntity<Item> updateById(@RequestBody ItemPutDTO itemPutDTO) {
        return ResponseEntity.ok(itemService.update(itemPutDTO));
    }

    /**
     * Apaga um Item por id
     *
     * @param id ID do Item
     * @return VAZIO
     */
    @ApiOperation(value = "Apaga um Item por id.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
