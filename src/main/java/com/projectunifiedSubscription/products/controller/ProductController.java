package com.projectunifiedSubscription.products.controller;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.dto.ProductDto;
import com.projectunifiedSubscription.products.response.GenericStringResponse;
import com.projectunifiedSubscription.products.response.ProductResponse;
import com.projectunifiedSubscription.products.service.Implementations.ProductServiceImpl;
import com.projectunifiedSubscription.products.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping(path = "/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        try {
            Product product = productService.add(productDto);
            return ResponseEntity.ok(new GenericStringResponse("Product added successfully"));
        } catch (GenericException e) {
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())), e.getStatus());
        }
    }
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
        try {
            Product product = productService.getById(id);
            return ResponseEntity.ok(new ProductResponse("Product retrieved", new Product[]{product}));
        } catch (GenericException e) {
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())), e.getStatus());
        }
    }

    @GetMapping(path = "/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }
}