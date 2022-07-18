package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.PedidoPostDTO;
import com.vendaprodutos.domain.dto.PedidoPutDTO;
import com.vendaprodutos.domain.dto.ProdutoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
import com.vendaprodutos.service.PedidoService;
import com.vendaprodutos.service.ProdutoService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 *
 * @author Samuel Silva
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
     * @param pedidoPostDTO Corpo PostDTO de Pedido
     * @return Pedido
     */
    @ApiOperation(value = "Insere um novo Pedido.")
    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoPostDTO pedidoPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoPostDTO));
    }

    /**
     * Busca todos os pedidos
     *
     * @return Lista de Pedido
     */
    @ApiOperation(value = "Busca todos os pedidos.")
    @GetMapping
    public ResponseEntity<List<Pedido>> list() {
        return ResponseEntity.ok(pedidoService.listAll());
    }

    /**
     * Busca um pedido por id
     *
     * @param id ID do Pedido
     * @return Pedido
     */
    @ApiOperation(value = "Busca um pedido por id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable long id) {
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    /**
     * Busca um produto por parâmetros
     *
     * @param id ID do Pedido
     * @param dataCadastro Data de cadastro do Pedido
     * @param cliente ID do Cliente do Pedido
     * @return Lista de Pedido
     */
    @ApiOperation(value = "Busca um pedido por parâmetros.")
    @GetMapping(path = "/find")
    public ResponseEntity<List<Pedido>> findByParameter(
            @RequestParam(required = false) Long id,
            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
            @Pattern(regexp = "([0-9]{4}[/][0-1][0-9][/][0-3][0-9][ ][0-2][0-9][:][0-5][0-9])")
            @RequestParam(required = false) LocalDateTime dataCadastro,
            @RequestParam(name = "clienteId", required = false) Cliente cliente) {

        List<Pedido> lista = pedidoService.findByParameter(id, dataCadastro, cliente);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca todos os pedidos, mas de forma paginada
     * É interessante usar os parâmetros "size", "page" e "sort"
     *
     * @param pageable Pageable
     * @return Page de Pedido
     */
    @ApiOperation(value = "Busca todos os pedidos, mas de forma paginada." +
            " É interessante usar os parâmetros \"size\", \"page\" e \"sort\"")
    @GetMapping(path = "/page")
    public ResponseEntity<Page<Pedido>> listPage(Pageable pageable) {
        return ResponseEntity.ok(pedidoService.listPage(pageable));
    }

    /**
     * Altera um Pedido por id
     *
     * @param pedidoPutDTO Corpo PutDTO de Pedido
     * @return Pedido
     */
    @ApiOperation(value = "Altera um pedido por id.")
    @PutMapping
    public ResponseEntity<Pedido> updateById(@RequestBody PedidoPutDTO pedidoPutDTO) {
        return ResponseEntity.ok(pedidoService.update(pedidoPutDTO));
    }

    /**
     * Apaga um pedido por id
     *
     * @param id ID do Pedido
     * @return VAZIO
     */
    @ApiOperation(value = "Apaga um pedido por id.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
