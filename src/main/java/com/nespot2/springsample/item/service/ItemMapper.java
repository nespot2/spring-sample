package com.nespot2.springsample.item.service;

import com.nespot2.springsample.item.domain.ItemCategory;
import com.nespot2.springsample.item.domain.dto.ItemCategoryDto;

public interface ItemMapper {
    ItemCategoryDto map(ItemCategory itemCategory);
}
