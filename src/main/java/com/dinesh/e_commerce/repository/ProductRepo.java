package com.dinesh.e_commerce.repository;

import com.dinesh.e_commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product , Long> {
}
