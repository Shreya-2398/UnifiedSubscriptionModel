package com.projectunifiedSubscription.products.service;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.dto.ProductDto;
import com.projectunifiedSubscription.products.entity.Product;
import com.projectunifiedSubscription.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(ProductDto productDto) {
        Optional<Product> findProduct = productRepository.findProductByName(productDto.getName());
        if (!findProduct.isEmpty()) {
            throw new GenericException("Product already exists", HttpStatus.CONFLICT);
        }

        Product product = new Product();
        product.setName(productDto.getName());
        product.setCompany(productDto.getCompany());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDurationInMonths(productDto.getDurationInMonths());
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> product = productRepository.findProductById(id);
        System.out.println(product.toString());
        if (!product.isEmpty()) {
            return product.get();
        } else {
            throw new GenericException("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
