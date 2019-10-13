package com.nespot2.springsample.item.service.impl;

import com.nespot2.springsample.item.domain.ItemCategory;
import com.nespot2.springsample.item.domain.dto.ItemCategoryDto;
import com.nespot2.springsample.item.service.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemMapperImpl implements ItemMapper {
    @Override
    public ItemCategoryDto map(ItemCategory itemCategory) {

        return ItemCategoryDto.builder()
                .name(itemCategory.getName())
                .id(itemCategory.getId())
                .modifiedAt(itemCategory.getModifiedAt())
                .build();
    }
}
