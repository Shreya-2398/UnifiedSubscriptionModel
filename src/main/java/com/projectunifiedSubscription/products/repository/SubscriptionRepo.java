package com.projectunifiedSubscription.products.repository;

import com.projectunifiedSubscription.products.dto.SubscriptionDto;
import com.projectunifiedSubscription.products.entity.Subscription;
import com.projectunifiedSubscription.products.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

    List<Subscription> findByUser(User user);
}
