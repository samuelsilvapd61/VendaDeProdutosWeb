package com.vendaprodutos.service;

import com.vendaprodutos.domain.Item;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.ItemPostDTO;
import com.vendaprodutos.domain.dto.ItemPutDTO;
import com.vendaprodutos.mapper.ItemMapper;
import com.vendaprodutos.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe Service de Item
 *
 * @author Samuel Silva
 */
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ProdutoService produtoService;
    private final PedidoService pedidoService;

    /**
     * Adiciona um Item ao banco de dados
     *
     * @param itemPostDTO ItemPostDTO
     * @return Item
     */
    public Item save(ItemPostDTO itemPostDTO) {
        Item item = ItemMapper.INSTANCE.toItem(itemPostDTO);
        pedidoService.findById(itemPostDTO.getPedidoId()); // Verificando se o pedido existe
        Produto produto = produtoService.findById(itemPostDTO.getProdutoId()); // Verificando se o produto existe
        item.setPrecoUnitario(produto.getPreco()); // Setando o preço do item com base no preço atual do produto
        return itemRepository.save(item);
    }

    /**
     * Lista todos os itens
     *
     * @return Lista de Item
     */
    public List<Item> listAll() {
        return itemRepository.findAll();
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
    public List<Item> findByParameter(Long id, Integer quantidade, Produto produto, Pedido pedido) {
        return itemRepository.findByIdOrQuantidadeOrProdutoOrPedido(id, quantidade, produto, pedido);
    }

    /**
     * Busca um Item por ID no banco de dados
     *
     * @param id ID de Item
     * @return Item
     */
    public Item findById(long id) {
        Optional<Item> optional = itemRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException();
    }

    /**
     * Busca todos os itens, mas de forma paginada
     *
     * @param pageable Pageable
     * @return Page de Pedido
     */
    public Page<Item> listPage(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    /**
     * Altera um Item por id no banco de dados
     *
     * @param itemPutDTO Corpo PutDTO de Item
     * @return Item
     */
    public Item update(ItemPutDTO itemPutDTO) {
        findById(itemPutDTO.getId()); // Verficar se Id de Item existe
        pedidoService.findById(itemPutDTO.getPedidoId()); // Verficar se Id de Pedido existe
        Produto produto = produtoService.findById(itemPutDTO.getProdutoId()); // Verficar se Id de Produto existe
        Item item = ItemMapper.INSTANCE.toItem(itemPutDTO);
        item.setPrecoUnitario(produto.getPreco());
        return itemRepository.save(item);
    }

    /**
     * Apaga um Item por id no banco de dados
     *
     * @param id ID do Item
     */
    public void delete(long id) {
        itemRepository.delete(findById(id));
    }
}
