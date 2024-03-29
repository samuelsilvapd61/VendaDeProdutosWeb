package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import com.vendaprodutos.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe para gerenciar rotas de clientes
 *
 * @author Samuel Silva
 */
@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    /**
     * Insere um novo Cliente
     *
     * @param clientePostDTO Corpo PostDTO de Cliente
     * @return Cliente
     */
    @ApiOperation(value = "Insere um novo Cliente.")
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClientePostDTO clientePostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clientePostDTO));
    }

    /**
     * Busca todos os clientes
     *
     * @return Lista de Clientes
     */
    @ApiOperation(value = "Busca todos os clientes.")
    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok(clienteService.listAll());
    }

    /**
     * Busca um cliente por id
     *
     * @param id ID do Cliente
     * @return Cliente
     */
    @ApiOperation(value = "Busca um cliente por id.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    /**
     * Busca um cliente por parâmetros
     *
     * @param id ID do Cliente
     * @param nomeCompleto Nome do Cliente
     * @param cpf CPF do Cliente
     * @param dataNascimento Data de nascimento do Cliente
     * @param genero Gênero do Cliente
     * @param email Email do Cliente
     * @param endereco Endereço do Cliente
     * @param telefone Telefone do Cliente
     * @param dataCadastro Data de cadastro do Cliente
     * @return Lista de Clientes
     */
    @ApiOperation(value = "Busca um cliente por parâmetros.")
    @GetMapping(path = "/find")
    public ResponseEntity<List<Cliente>> findByParameter(
            @RequestParam(required = false, defaultValue = "0") Long id,
            @RequestParam(required = false) String nomeCompleto,
            @RequestParam(required = false) @Pattern(regexp = "([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[-][0-9]{2})") String cpf,
            @DateTimeFormat(pattern = "yyyy/MM/dd") @Pattern(regexp = "([0-9]{4}[/][0-1][0-9][/][0-3][0-9])") @RequestParam(required = false) LocalDate dataNascimento,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String endereco,
            @RequestParam(required = false) String telefone,
            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm") @Pattern(regexp = "([0-9]{4}[/][0-1][0-9][/][0-3][0-9][ ][0-2][0-9][:][0-5][0-9])") @RequestParam(required = false) LocalDateTime dataCadastro) {

        List<Cliente> lista = clienteService.findByParameter(id, nomeCompleto, cpf, dataNascimento, genero, email, endereco, telefone, dataCadastro);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca todos os clientes, mas de forma paginada
     * É interessante usar os parâmetros "size", "page" e "sort"
     *
     * @param pageable Pageable
     * @return Page de Cliente
     */
    @ApiOperation(value = "Busca todos os clientes, mas de forma paginada." +
            " É interessante usar os parâmetros \"size\", \"page\" e \"sort\"")
    @GetMapping(path = "/page")
    public ResponseEntity<Page<Cliente>> listPage(Pageable pageable) {
        return ResponseEntity.ok(clienteService.listPage(pageable));
    }

    /**
     * Apaga um cliente por id
     *
     * @param id ID do Cliente
     * @return VAZIO
     */
    @ApiOperation(value = "Apaga um cliente por id.")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Altera um cliente por id
     *
     * @param clientePutDTO Corpo PutDTO de Cliente
     * @return Cliente
     */
    @ApiOperation(value = "Altera um cliente por id.")
    @PutMapping
    public ResponseEntity<Cliente> updateById(@RequestBody @Valid ClientePutDTO clientePutDTO) {
        return ResponseEntity.ok(clienteService.update(clientePutDTO));
    }

}
