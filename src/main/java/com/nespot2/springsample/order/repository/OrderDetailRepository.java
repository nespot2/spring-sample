package com.nespot2.springsample.order.repository;

import com.nespot2.springsample.order.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
