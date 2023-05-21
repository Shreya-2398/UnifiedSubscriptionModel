package com.projectunifiedSubscription.products.repository;

import com.projectunifiedSubscription.products.entity.PlanProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanProductRepo extends JpaRepository<PlanProduct, Integer> {

    PlanProduct[] findProductByPlanId(Integer planId);
}