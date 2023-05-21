package com.projectunifiedSubscription.products.service;

import com.projectunifiedSubscription.products.dto.ProductDto;
import com.projectunifiedSubscription.products.entity.Product;

import java.util.List;

public interface ProductService {

    Product add(ProductDto productDto);

    Product getById(Integer id);

    List<Product> getAll();
}
