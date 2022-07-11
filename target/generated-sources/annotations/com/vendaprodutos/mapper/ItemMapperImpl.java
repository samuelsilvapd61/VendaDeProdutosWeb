package com.vendaprodutos.mapper;

import com.vendaprodutos.domain.Item;
import com.vendaprodutos.domain.Item.ItemBuilder;
import com.vendaprodutos.domain.dto.ItemPostDTO;
import com.vendaprodutos.domain.dto.ItemPutDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-11T13:50:42-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
@Component
public class ItemMapperImpl extends ItemMapper {

    @Override
    public Item toItem(ItemPostDTO itemPostDTO) {
        if ( itemPostDTO == null ) {
            return null;
        }

        ItemBuilder item = Item.builder();

        return item.build();
    }

    @Override
    public Item toItem(ItemPutDTO itemPutDTO) {
        if ( itemPutDTO == null ) {
            return null;
        }

        ItemBuilder item = Item.builder();

        item.id( itemPutDTO.getId() );

        return item.build();
    }
}
