package com.nespot2.springsample.item.repository;

import com.nespot2.springsample.item.domain.ItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDetailRepository extends JpaRepository<ItemDetail, Long> {
}
