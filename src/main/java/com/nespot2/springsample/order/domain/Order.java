package com.nespot2.springsample.order.domain;

import com.nespot2.springsample.member.domain.Member;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@ToString(exclude = {"member"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private OffsetDateTime modifiedAt;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private int price;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Order(OffsetDateTime modifiedAt, OffsetDateTime createdAt, int price, OrderStatus status, Member member) {
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.price = price;
        this.status = status;
        this.member = member;
    }
}
