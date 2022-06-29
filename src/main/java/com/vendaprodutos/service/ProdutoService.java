package com.vendaprodutos.service;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.Cliente;
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

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public Produto save(ProdutoPostDTO produtoPostDTO) {
        //Categoria categoria = categoriaRepository.
        Produto produto = ProdutoMapper.INSTANCE.toProduto(produtoPostDTO);
        return produtoRepository.save(produto);
    }

    public List<Produto> listAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }

    public List<Produto> findByParameter(Long id, String nome, String descricao, Double preco, LocalDateTime dataCadastro, Categoria categoria) {
        return produtoRepository.findByIdOrNomeOrDescricaoOrPrecoOrDataCadastroOrCategoria(id, nome, descricao, preco, dataCadastro, categoria);
    }

    public Page<Produto> listPage(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto update(ProdutoPutDTO produtoPutDTO) {
        Produto savedProduto = findById(produtoPutDTO.getId());
        Produto produto = ProdutoMapper.INSTANCE.toProduto(produtoPutDTO);
        produto.setId(savedProduto.getId()); // Garantir que o id está correto
        produto.setDataCadastro(savedProduto.getDataCadastro()); // Preencher a dataCadastro
        return produtoRepository.save(produto);
    }


    public void delete(long id) {
        produtoRepository.delete(findById(id));
    }
}
