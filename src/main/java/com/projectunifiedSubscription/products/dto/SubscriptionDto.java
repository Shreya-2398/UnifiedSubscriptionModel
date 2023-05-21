package com.projectunifiedSubscription.products.dto;

import com.projectunifiedSubscription.products.entity.PlanProduct;
import com.projectunifiedSubscription.products.entity.User;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    private Long id;
    private Long userId;
    private int planId;
    private LocalDate startDate;
    private LocalDate endDate;
//    private int planPrice;

   }