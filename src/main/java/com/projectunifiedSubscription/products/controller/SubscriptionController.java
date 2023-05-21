package com.projectunifiedSubscription.products.controller;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.dto.SubscriptionDto;
import com.projectunifiedSubscription.products.entity.Subscription;
import com.projectunifiedSubscription.products.response.GenericStringResponse;
import com.projectunifiedSubscription.products.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<?> issueSubscription(@RequestBody SubscriptionDto subscriptionDto) {
        try {
            subscriptionService.issueSubscription(subscriptionDto);
            return ResponseEntity.ok(new GenericStringResponse("Subscription issued successfully"));
        } catch (GenericException e) {
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())), e.getStatus());
        }
    }
    @GetMapping(path = "/{userId}")
    public List<Subscription> getUserSubscriptions(@PathVariable Long userId) {
        return subscriptionService.getUserSubscription(userId);
    }
    }

