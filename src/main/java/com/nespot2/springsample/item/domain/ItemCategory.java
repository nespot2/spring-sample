package com.nespot2.springsample.item.domain;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private OffsetDateTime modifiedAt;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Builder
    public ItemCategory(String name, OffsetDateTime modifiedAt, OffsetDateTime createdAt) {
        this.name = name;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
    }
}
