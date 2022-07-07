package com.vendaprodutos.service;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.ProdutoPostDTO;
import com.vendaprodutos.domain.dto.ProdutoPutDTO;
import com.vendaprodutos.mapper.ProdutoMapper;
import com.vendaprodutos.repository.CategoriaRepository;
import com.vendaprodutos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Classe Service de Produto
 *
 * @author Samuel Silva
 */
@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    /**
     * Adiciona uma Categoria ao banco de dados
     *
     * @param produtoPostDTO PedidoPostDTO
     * @return Pedido
     */
    public Produto save(ProdutoPostDTO produtoPostDTO) {
        //Categoria categoria = categoriaRepository.
        Produto produto = ProdutoMapper.INSTANCE.toProduto(produtoPostDTO);
        return produtoRepository.save(produto);
    }

    /**
     * Lista todos os produtos
     *
     * @return Lista de Produto
     */
    public List<Produto> listAll() {
        return produtoRepository.findAll();
    }

    /**
     * Busca um Produto por ID
     *
     * @param id ID de Produto
     * @return Produto
     */
    public Produto findById(long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }

    /**
     * Busca produtos por parâmetros
     *
     * @param id ID de Produto
     * @param nome Nome de Produto
     * @param descricao Descrição de Produto
     * @param preco Preço de Produto
     * @param dataCadastro Data de cadastro de Produto
     * @param categoria ID de Categoria de Produto
     * @return Lista de Produto
     */
    public List<Produto> findByParameter(Long id, String nome, String descricao, Double preco, LocalDateTime dataCadastro, Categoria categoria) {
        return produtoRepository.findByIdOrNomeOrDescricaoOrPrecoOrDataCadastroOrCategoria(id, nome, descricao, preco, dataCadastro, categoria);
    }

    /**
     * Busca todos os produtos, mas de forma paginada
     *
     * @param pageable Pageable
     * @return Page de Produto
     */
    public Page<Produto> listPage(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    /**
     * Altera um produto por id no banco de dados
     *
     * @param produtoPutDTO Corpo PutDTO de Produto
     * @return Produto
     */
    public Produto update(ProdutoPutDTO produtoPutDTO) {
        Produto savedProduto = findById(produtoPutDTO.getId());
        Produto produto = ProdutoMapper.INSTANCE.toProduto(produtoPutDTO);
        produto.setId(savedProduto.getId()); // Garantir que o id está correto
        produto.setDataCadastro(savedProduto.getDataCadastro()); // Preencher a dataCadastro
        return produtoRepository.save(produto);
    }

    /**
     * Apaga um produto por id no banco de dados
     *
     * @param id ID do Produto
     */
    public void delete(long id) {
        produtoRepository.delete(findById(id));
    }
}
