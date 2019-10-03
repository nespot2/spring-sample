package com.nespot2.springsample.item.domain;

import com.nespot2.springsample.common.domain.YesNo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int initQuantity;

    @Column(nullable = false)
    private int releasedQuantity;

    @Column(nullable = false)
    private int inventoryQuantity;

    @Column(nullable = false)
    private YesNo quickDeliveryYn;

    @Column(nullable = false)
    private OffsetDateTime modified_at;

    @Column(nullable = false)
    private OffsetDateTime created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_category_id")
    private ItemCategory itemCategory;

    @Builder
    public Item(String name, int initQuantity, int releasedQuantity, int inventoryQuantity, YesNo quickDeliveryYn, OffsetDateTime modified_at, OffsetDateTime created_at, ItemCategory itemCategory) {
        this.name = name;
        this.initQuantity = initQuantity;
        this.releasedQuantity = releasedQuantity;
        this.inventoryQuantity = inventoryQuantity;
        this.quickDeliveryYn = quickDeliveryYn;
        this.modified_at = modified_at;
        this.created_at = created_at;
        this.itemCategory = itemCategory;
    }
}
