package com.nespot2.springsample.item.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

/**
 * @author nepsot2
 * @version 0.0.1
 * @since 2019-10-05
 */
@Getter
@ToString
public class ItemCategoryDto {

    private long id;

    private String name;

    private OffsetDateTime modifiedAt;


    @Builder
    public ItemCategoryDto(long id, String name, OffsetDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.modifiedAt = modifiedAt;
    }
}
