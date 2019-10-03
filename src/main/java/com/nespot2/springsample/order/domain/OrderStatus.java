package com.nespot2.springsample.order.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum OrderStatus {
    PURCHASE_COMPLETED("구매 완료"),
    PREPARING_FOR_DELIVERY("배송 준비중"),
    DELIVERY_COMPLETED("배송 완료"),
    CONFIRMATION_OF_PURCHASE("구매 확정"),
    CANCEL_PURCHASE("구매 취소");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
