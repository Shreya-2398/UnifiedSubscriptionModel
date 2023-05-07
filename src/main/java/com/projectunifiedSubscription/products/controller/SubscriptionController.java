package com.projectunifiedSubscription.products.controller;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.dto.SubscriptionDto;
import com.projectunifiedSubscription.products.dto.UpdatePlanDto;
import com.projectunifiedSubscription.products.entity.SubscriptionPlan;
import com.projectunifiedSubscription.products.response.GenericStringResponse;
import com.projectunifiedSubscription.products.service.SubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionServiceImpl subscriptionService;

    @PostMapping(path = "/createSubscriptions")
    public ResponseEntity<?> addSubscription(@RequestBody SubscriptionDto subscriptionDto){
        try {
            SubscriptionPlan subscriptionPlan = subscriptionService.addSubscription(subscriptionDto);
            return ResponseEntity.ok(new GenericStringResponse("Plan created successfully"));
        } catch (GenericException e){
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())),e.getStatus());
        }
    }

    @PutMapping(path = "/getById")
    public ResponseEntity<?> updateSubscription(@RequestBody UpdatePlanDto updatePlanDto){
        try{
            SubscriptionPlan subscriptionPlan = subscriptionService.updateSubscription(updatePlanDto);
            return ResponseEntity.ok(new GenericStringResponse("Subscription cost updated successfully"));
        }catch(GenericException e){
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())),e.getStatus());
        }
    }

    @PutMapping(path = "/{id}/pause")
    public ResponseEntity<?> pauseSubscription(@PathVariable int id){
        try{
            SubscriptionPlan subscriptionPlan = subscriptionService.pauseSubscription(id);
            return ResponseEntity.ok(new GenericStringResponse("Subscription is now paused"));
        }catch(GenericException e){
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())),e.getStatus());
        }
    }
}
