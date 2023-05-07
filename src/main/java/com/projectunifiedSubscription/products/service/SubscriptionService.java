package com.projectunifiedSubscription.products.service;

import com.projectunifiedSubscription.products.dto.SubscriptionDto;
import com.projectunifiedSubscription.products.dto.UpdatePlanDto;
import com.projectunifiedSubscription.products.entity.SubscriptionPlan;

public interface SubscriptionService {
    SubscriptionPlan addSubscription(SubscriptionDto subscriptionDto);

    SubscriptionPlan updateSubscription(UpdatePlanDto updatePlanDto);

    SubscriptionPlan pauseSubscription(int id);
}
