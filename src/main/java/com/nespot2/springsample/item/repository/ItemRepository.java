package com.nespot2.springsample.item.repository;

import com.nespot2.springsample.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
