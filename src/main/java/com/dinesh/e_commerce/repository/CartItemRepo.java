package com.dinesh.e_commerce.repository;

import com.dinesh.e_commerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem , Long> {
}
