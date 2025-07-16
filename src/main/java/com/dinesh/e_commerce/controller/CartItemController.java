package com.dinesh.e_commerce.controller;


import com.dinesh.e_commerce.entity.CartItem;
import com.dinesh.e_commerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public ResponseEntity<List<CartItem>> get(){
        return ResponseEntity.status(HttpStatus.FOUND).body(cartItemService.getCart());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeItem(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.OK).body(cartItemService.revoveItem(id));
    }

    @PostMapping("/add")
    public ResponseEntity<CartItem> addCart(@RequestParam Long productId, @RequestParam int quantity){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemService.add(productId,quantity));
    }

}
