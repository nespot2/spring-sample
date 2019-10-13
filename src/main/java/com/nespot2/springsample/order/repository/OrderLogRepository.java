package com.nespot2.springsample.order.repository;

import com.nespot2.springsample.order.domain.OrderLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLogRepository extends JpaRepository<OrderLog, Long> {
}
