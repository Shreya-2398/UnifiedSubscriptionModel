package com.projectunifiedSubscription.products.service;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.dto.SubscriptionDto;
import com.projectunifiedSubscription.products.dto.UpdatePlanDto;
import com.projectunifiedSubscription.products.entity.Product;
import com.projectunifiedSubscription.products.entity.SubscriptionPlan;
import com.projectunifiedSubscription.products.repository.ProductRepository;
import com.projectunifiedSubscription.products.repository.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ProductService productService;

    @Override
    public SubscriptionPlan addSubscription(SubscriptionDto subscriptionDto) {
        Optional<SubscriptionPlan> findSubscriptionPlan = subscriptionRepo.findProductByName(subscriptionDto.getName());
        if (!findSubscriptionPlan.isEmpty()) {
            throw new GenericException("Plan already exists", HttpStatus.CONFLICT);
        }
        for (int i = 0; i<subscriptionDto.getProducts().length; i++){
            productService.getProductById(subscriptionDto.getProducts()[i].getId());
        }
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        subscriptionPlan.setName(subscriptionDto.getName());
        subscriptionPlan.setPrice(subscriptionDto.getPrice());
        subscriptionRepo.save(subscriptionPlan);
        return subscriptionPlan;
    }

    @Override
    public SubscriptionPlan updateSubscription(UpdatePlanDto updatePlanDto) {
       Optional <SubscriptionPlan> updateSubscriptionPlan = subscriptionRepo.findProductById(updatePlanDto.getId());
       if (!updateSubscriptionPlan.isEmpty()) {
           throw new GenericException("Subscription not found", HttpStatus.NOT_FOUND);
       }
//       SubscriptionPlan updateSubscriptionPlan = new SubscriptionPlan();
        updateSubscriptionPlan.setId(updatePlanDto.getId());
        updateSubscriptionPlan.setPrice(updatePlanDto.getPrice());
       subscriptionRepo.save(subscriptionPlan);
       return subscriptionPlan;
       }

       @Override
       public SubscriptionPlan pauseSubscription(int id){
        Optional <SubscriptionPlan> pauseSubscriptionPlan = subscriptionRepo.findProductById(id);
        if(!pauseSubscriptionPlan.isEmpty()) {
            throw new GenericException("Subscription plan not found", HttpStatus.NOT_FOUND);
        }

        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        subscriptionPlan.setPaused(true);
        subscriptionRepo.save(subscriptionPlan);
        return subscriptionPlan;
       }
    }

