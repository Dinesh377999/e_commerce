package com.dinesh.e_commerce.service;

import com.dinesh.e_commerce.entity.Product;
import com.dinesh.e_commerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public Product add(Product product) {
        return productRepo.save(product);
    }

    public List<Product> addAll(List<Product> products) {
        return productRepo.saveAll(products);
    }

    public Product update(Product product, Long id) {
        Optional<Product> product1 = productRepo.findById(id);
        if (product1.isPresent()){
            Product updateProduct = product1.get();
            updateProduct.setName(product.getName());
            updateProduct.setCategory(product.getCategory());
            updateProduct.setPrice(product.getPrice());
            updateProduct.setDescription(product.getDescription());

            return productRepo.save(updateProduct);
        }
        else
            throw new RuntimeException("Product with " +id+ " not exist");
    }

    public String delete(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()){
            productRepo.delete(product.get());
            return "Deleted";
        }
        else
            throw new RuntimeException("Product not found with ID: " + id);
    }

    public Product getProduct(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RuntimeException("Product not found with ID: " + id);
        }
    }

}
