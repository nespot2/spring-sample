package com.nespot2.springsample.order.repository;

import com.nespot2.springsample.order.domain.SimpleOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<SimpleOrder, Long> {
}
