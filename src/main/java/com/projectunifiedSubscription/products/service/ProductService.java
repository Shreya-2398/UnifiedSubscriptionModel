package com.projectunifiedSubscription.products.service;

import com.projectunifiedSubscription.products.dto.ProductDto;
import com.projectunifiedSubscription.products.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductDto productDto);

    Product getProductById(Integer id);

    List<Product> getAllProducts();
}
