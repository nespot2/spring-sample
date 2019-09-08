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
    private OffsetDateTime modified_at;

    @Column(nullable = false)
    private OffsetDateTime created_at;

    @Builder
    public ItemCategory(String name, OffsetDateTime modified_at, OffsetDateTime created_at) {
        this.name = name;
        this.modified_at = modified_at;
        this.created_at = created_at;
    }
}
