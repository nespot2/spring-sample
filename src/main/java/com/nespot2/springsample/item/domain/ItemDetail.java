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
    private OffsetDateTime modified_at;

    @Column(nullable = false)
    private OffsetDateTime created_at;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Builder
    public ItemDetail(String inventoryNumber, OffsetDateTime modified_at, OffsetDateTime created_at, ItemStatus status, Item item) {
        this.inventoryNumber = inventoryNumber;
        this.modified_at = modified_at;
        this.created_at = created_at;
        this.status = status;
        this.item = item;
    }
}
