package com.dinesh.e_commerce.service;

import com.dinesh.e_commerce.entity.CartItem;
import com.dinesh.e_commerce.entity.Product;
import com.dinesh.e_commerce.repository.CartItemRepo;
import com.dinesh.e_commerce.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private ProductRepo productRepo;

    public List<CartItem> getCart() {
        return cartItemRepo.findAll();
    }

    public String revoveItem(Long id) {
        Optional<CartItem> cartItem = cartItemRepo.findById(id);
        if (cartItem.isPresent()){
            cartItemRepo.delete(cartItem.get());
            return "Deleted";
        }
        else
            throw new RuntimeException("CartItem not found with ID: " + id);

    }
    public void clearCart(){
        cartItemRepo.deleteAll();
    }

    public CartItem add(Long productId, int quantity) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem item =new CartItem(null , product , quantity);
        return cartItemRepo.save(item);
    }
}
