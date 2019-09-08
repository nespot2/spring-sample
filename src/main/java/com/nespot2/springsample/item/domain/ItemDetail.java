package com.nespot2.springsample.item.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String inventoryNumber;

    @Column(nullable = false)
    private OffsetDateTime modified_at;

    @Column(nullable = false)
    private OffsetDateTime created_at;

    private ItemStatus status;
}
