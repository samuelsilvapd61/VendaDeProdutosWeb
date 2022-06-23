package com.vendaprodutos.controller;

import com.vendaprodutos.domain.Cliente;
import com.vendaprodutos.domain.dto.ClientePostDTO;
import com.vendaprodutos.domain.dto.ClientePutDTO;
import com.vendaprodutos.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * @param clientePostDTO
     */
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClientePostDTO clientePostDTO) {
        //return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clientePostDTO));
    }

    /**
     * Busca todos os clientes
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        //log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(clienteService.listAll());
    }

    /**
     * Busca um cliente por id
     * @param id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    /**
     * Apaga um cliente por id
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Altera um cliente por id
     * @param clientePutDTO
     */
    @PutMapping
    public ResponseEntity<Cliente> updateById(@RequestBody ClientePutDTO clientePutDTO) {
        return ResponseEntity.ok(clienteService.update(clientePutDTO));
    }

}
