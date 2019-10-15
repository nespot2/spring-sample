package com.nespot2.springsample.order.domain;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private SimpleOrder order;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Builder
    public OrderLog(SimpleOrder order, OrderStatus orderStatus, OffsetDateTime createdAt) {
        this.order = order;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }
}
