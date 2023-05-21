package com.projectunifiedSubscription.products.repository;

import com.projectunifiedSubscription.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    Optional<Product> findProductByName(String name);

    Optional<Product> findProductById(Integer id);
}