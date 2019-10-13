package com.nespot2.springsample.item.domain;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"item"})
public class ItemDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String inventoryNumber;

    @Column(nullable = false)
    private OffsetDateTime modifiedAt;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    public ItemDetail(String inventoryNumber, OffsetDateTime modifiedAt, OffsetDateTime createdAt, ItemStatus status, Item item) {
        this.inventoryNumber = inventoryNumber;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.status = status;
        this.item = item;
    }
}
