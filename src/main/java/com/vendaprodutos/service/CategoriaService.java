package com.vendaprodutos.service;

import com.vendaprodutos.domain.Categoria;
import com.vendaprodutos.domain.dto.CategoriaPostDTO;
import com.vendaprodutos.domain.dto.CategoriaPutDTO;
import com.vendaprodutos.mapper.CategoriaMapper;
import com.vendaprodutos.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Classe Service de Categoria
 *
 * @author Samuel Silva
 */
@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    /**
     * Adiciona uma Categoria ao banco de dados
     *
     * @param categoriaPostDTO CategoriaPostDTO
     * @return Categoria
     */
    @Transactional
    public Categoria save(CategoriaPostDTO categoriaPostDTO) {
        Categoria categoria = CategoriaMapper.INSTANCE.toCategoria(categoriaPostDTO);
        return categoriaRepository.save(categoria);
    }

    /**
     * Lista todas as categorias
     *
     * @return Lista de Produto
     */
    public List<Categoria> listAll() {
        return categoriaRepository.findAll();
    }

    /**
     * Busca um Produto por ID
     *
     * @param id ID de Produto
     * @return Produto
     */
    public Categoria findById(long id) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }

    /**
     * Busca categorias por parâmetros
     *
     * @param id ID de Categoria
     * @param nome Nome de Categoria
     * @return Lista de Categoria
     */
    public List<Categoria> findByParameter(Long id, String nome) {
        return categoriaRepository.findByIdOrNome(id, nome);
    }

    /**
     * Busca todas as categorias, mas de forma paginada
     *
     * @param pageable Pageable
     * @return Page de Categoria
     */
    public Page<Categoria> listPage(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    /**
     * Altera uma categoria por id no banco de dados
     *
     * @param categoriaPutDTO Corpo PutDTO de Categoria
     * @return Lista de Categoria
     */
    public Categoria update(CategoriaPutDTO categoriaPutDTO) {
        Categoria savedCategoria = findById(categoriaPutDTO.getId());
        Categoria categoria = CategoriaMapper.INSTANCE.toCategoria(categoriaPutDTO);
        categoria.setId(savedCategoria.getId()); // Garantir que o id está correto
        return categoriaRepository.save(categoria);
    }

    /**
     * Apaga uma categoria por id no banco de dados
     *
     * @param id ID da Categoria
     */
    public void delete(long id) {
        categoriaRepository.delete(findById(id));
    }
}
