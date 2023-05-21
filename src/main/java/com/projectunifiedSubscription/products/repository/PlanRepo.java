package com.projectunifiedSubscription.products.repository;

import com.projectunifiedSubscription.products.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

    Optional<Plan> findProductByName(String name);

    Optional <Plan> findProductById(int id);

}
