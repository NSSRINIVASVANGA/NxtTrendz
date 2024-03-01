package com.example.nxttrendz1.controller;

import com.example.nxttrendz1.model.*;
import com.example.nxttrendz1.repository.*;
import com.example.nxttrendz1.service.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
public class ProductController {
    @Autowired
    public ProductJpaService productService;

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        productService.deleteProduct(productId);
    }
}