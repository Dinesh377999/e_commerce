package com.dinesh.e_commerce.controller;

import com.dinesh.e_commerce.entity.CartItem;
import com.dinesh.e_commerce.entity.Order;
import com.dinesh.e_commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.status(HttpStatus.FOUND).body(orderService.get());
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrders(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.delete());
    }
}
