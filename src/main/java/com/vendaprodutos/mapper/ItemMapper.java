package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Item;
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

    public Item toItem(ItemPostDTO itemPostDTO) {
        if ( itemPostDTO == null ) {
            return null;
        }

        Item.ItemBuilder item = Item.builder();

        return item.build();
    }
    public Item toItem(ItemPutDTO itemPutDTO) {
        if ( itemPutDTO == null ) {
            return null;
        }

        Item.ItemBuilder item = Item.builder();

        item.id( itemPutDTO.getId() );

        return item.build();
    }

}
