package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import com.vendaprodutos.service.ClienteService;
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
 * Classe para gerenciar rotas de clientes
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
     * @param clientePostDTO
     */
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid ClientePostDTO clientePostDTO) {
        //return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clientePostDTO));
    }

    /**
     * Busca todos os clientes
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok(clienteService.listAll());
    }

    /**
     * Busca um cliente por id
     *
     * @param id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    /**
     * Busca um cliente por parâmetros
     *
     * @param id
     * @param nomeCompleto
     * @param cpf
     * @param dataNascimento
     * @param genero
     * @param email
     * @param endereco
     * @param telefone
     * @param dataCadastro
     */
    @GetMapping(path = "/find")
    public ResponseEntity<List<Cliente>> findByParameter(
            @RequestParam(required = false, defaultValue = "0") Long id,
            @RequestParam(required = false) String nomeCompleto,
            @RequestParam(required = false) String cpf,
            @DateTimeFormat(pattern = "yyyy/MM/dd") @RequestParam(required = false) LocalDate dataNascimento,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String endereco,
            @RequestParam(required = false) String telefone,
            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm") @RequestParam(required = false) LocalDateTime dataCadastro) {

        List<Cliente> lista = clienteService.findByParameter(id, nomeCompleto, cpf, dataNascimento, genero, email, endereco, telefone, dataCadastro);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca todos os clientes, mas de forma paginada
     * É interessante usar os parâmetros "size", "page" e "sort"
     * @param pageable
     */
    @GetMapping(path = "/page")
    public ResponseEntity<Page<Cliente>> listPage(Pageable pageable) {
        return ResponseEntity.ok(clienteService.listPage(pageable));
    }

    /**
     * Apaga um cliente por id
     *
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Altera um cliente por id
     *
     * @param clientePutDTO
     */
    @PutMapping
    public ResponseEntity<Cliente> updateById(@RequestBody @Valid ClientePutDTO clientePutDTO) {
        return ResponseEntity.ok(clienteService.update(clientePutDTO));
    }

}
