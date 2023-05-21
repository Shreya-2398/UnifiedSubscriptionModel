package com.projectunifiedSubscription.products.service;

import com.projectunifiedSubscription.products.dto.SubscriptionDto;
import com.projectunifiedSubscription.products.entity.Subscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    Subscription issueSubscription(SubscriptionDto subscriptionDto);

    List<Subscription> getUserSubscription(Long userId);
}
