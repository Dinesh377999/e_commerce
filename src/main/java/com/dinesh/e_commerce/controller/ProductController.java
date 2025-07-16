package com.dinesh.e_commerce.controller;

import com.dinesh.e_commerce.entity.Product;
import com.dinesh.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(product));
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<Product>> addAll(@RequestBody List<Product> products){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addAll(products));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product , @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(product , id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(productService.getProduct(id));
    }
}
