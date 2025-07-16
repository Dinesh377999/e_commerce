package com.dinesh.e_commerce.service;

import com.dinesh.e_commerce.entity.CartItem;
import com.dinesh.e_commerce.entity.Order;
import com.dinesh.e_commerce.entity.OrderItem;
import com.dinesh.e_commerce.entity.Product;
import com.dinesh.e_commerce.repository.OrderRepo;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CartItemService cartItemService;

    public List<Order> get() {
        return orderRepo.findAll();
    }

    public Order placeOrder() {
        List<CartItem> items = cartItemService.getCart();
        if (items == null || items.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        double total = 0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : items) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            double price = product.getPrice();

            total += +price * quantity;

            OrderItem orderItem = new OrderItem(product, quantity, price);
            orderItems.add(orderItem);
        }

        Order order = new Order(null, total, orderItems, LocalDateTime.now());

        Order saved = orderRepo.save(order);
        cartItemService.clearCart();

        return saved;

    }

    public String delete() {
        orderRepo.deleteAll();
        return "Deleted";
    }
}
