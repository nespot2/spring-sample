package com.nespot2.springsample.item.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ItemStatus {
    PURCHASE_POSSIBLE("구매 가능"),
    DURING_DELIVERY("배송중"),
    PURCHASE_CONFIRMATION("구매 완료"),
    PURCHASE_CANCEL("구매 취소"),
    SCRAP("폐품");

    private String value;

    ItemStatus(String value) {
        this.value = value;
    }
}
