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

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    @Transactional
    public Categoria save(CategoriaPostDTO categoriaPostDTO) {
        Categoria categoria = CategoriaMapper.INSTANCE.toCategoria(categoriaPostDTO);
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(long id) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }

    public List<Categoria> findByParameter(Long id, String nome) {
        return categoriaRepository.findByIdOrNome(id, nome);
    }

    public Page<Categoria> listPage(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    public Categoria update(CategoriaPutDTO categoriaPutDTO) {
        Categoria savedCategoria = findById(categoriaPutDTO.getId());
        Categoria categoria = CategoriaMapper.INSTANCE.toCategoria(categoriaPutDTO);
        categoria.setId(savedCategoria.getId()); // Garantir que o id está correto
        return categoriaRepository.save(categoria);
    }

    public void delete(long id) {
        categoriaRepository.delete(findById(id));
    }
}
