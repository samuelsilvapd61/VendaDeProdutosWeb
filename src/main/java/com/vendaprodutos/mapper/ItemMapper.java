package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Item;
import com.vendaprodutos.domain.Pedido;
import com.vendaprodutos.domain.Produto;
import com.vendaprodutos.domain.dto.ItemPostDTO;
import com.vendaprodutos.domain.dto.ItemPutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Classe de mapeamento de Item
 *
 * @author Samuel Silva
 */
@Mapper(componentModel = "spring")
public abstract class ItemMapper {

    /**
     * INSTANCE
     */
    public static final ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    /**
     * Passa os atributos de ItemPostDTO para um objeto Item
     *
     * @param itemPostDTO ItemPostDTO
     * @return Item
     */
    public Item toItem(ItemPostDTO itemPostDTO) {
        if ( itemPostDTO == null ) {
            return null;
        }

        Item.ItemBuilder item = Item.builder();

        item.quantidade( itemPostDTO.getQuantidade() );
        item.pedido(Pedido.builder().id(itemPostDTO.getPedidoId()).build());
        item.produto(Produto.builder().id(itemPostDTO.getProdutoId()).build());

        return item.build();
    }

    /**
     * Passa os atributos de ItemPutDTO para um objeto Item
     *
     * @param itemPutDTO ItemPutDTO
     * @return Item
     */
    public Item toItem(ItemPutDTO itemPutDTO) {
        if ( itemPutDTO == null ) {
            return null;
        }

        Item.ItemBuilder item = Item.builder();

        item.id( itemPutDTO.getId() );
        item.quantidade( itemPutDTO.getQuantidade() );
        item.pedido(Pedido.builder().id(itemPutDTO.getPedidoId()).build());
        item.produto(Produto.builder().id(itemPutDTO.getProdutoId()).build());

        return item.build();
    }

}
