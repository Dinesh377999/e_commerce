package com.dinesh.e_commerce.repository;

import com.dinesh.e_commerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order , Long> {
}
