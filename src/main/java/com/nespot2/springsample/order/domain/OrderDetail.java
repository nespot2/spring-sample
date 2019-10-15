package com.nespot2.springsample.order.domain;

import com.nespot2.springsample.item.domain.ItemDetail;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@ToString(exclude = {"order", "itemDetail"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private SimpleOrder order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_detail_id")
    private ItemDetail itemDetail;

    @Column(nullable = false)
    private OffsetDateTime modifiedAt;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Builder
    public OrderDetail(SimpleOrder order, ItemDetail itemDetail, OffsetDateTime modifiedAt, OffsetDateTime createdAt, OrderStatus orderStatus) {
        this.order = order;
        this.itemDetail = itemDetail;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.orderStatus = orderStatus;
    }
}
