package com.projectunifiedSubscription.products.repository;

import com.projectunifiedSubscription.products.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepo extends JpaRepository<SubscriptionPlan, Integer> {

    Optional<SubscriptionPlan> findProductByName(String name);

    Optional <SubscriptionPlan> findProductById(int id);

}
