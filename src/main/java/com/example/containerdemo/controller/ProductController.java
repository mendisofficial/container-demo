package com.example.containerdemo.controller;

import com.example.containerdemo.controller.model.ProductID;
import com.example.containerdemo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/product")
    public ResponseEntity<ProductID> createProduct(@RequestBody final Product product) {
        System.out.println(product);
        ProductID result = new ProductID(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/product")
    public List<Product> getProducts() {
       List<Product> result = new ArrayList<>();

         result.add(new Product("1", "Product 1", new BigDecimal("100.00")));
         result.add(new Product("2", "Product 2", new BigDecimal("200.00")));
         result.add(new Product("3", "Product 3", new BigDecimal("300.00")));

         return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id) {
        System.out.println(id);
        return new Product(id, "Product " + id, new BigDecimal("100.00"));
    }

    @PatchMapping("/product")
    public void patchProduct(@RequestBody Product product) {
        System.out.println(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable final String id) {
        System.out.println(id);
    }
}
