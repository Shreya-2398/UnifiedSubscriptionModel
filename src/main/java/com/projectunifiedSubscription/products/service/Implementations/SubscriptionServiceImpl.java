package com.projectunifiedSubscription.products.service.Implementations;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.dto.SubscriptionDto;
import com.projectunifiedSubscription.products.entity.Plan;
import com.projectunifiedSubscription.products.entity.PlanData;
import com.projectunifiedSubscription.products.entity.Subscription;
import com.projectunifiedSubscription.products.entity.User;
import com.projectunifiedSubscription.products.repository.SubscriptionRepo;
import com.projectunifiedSubscription.products.repository.UserRepo;
import com.projectunifiedSubscription.products.repository.PlanRepo;
import com.projectunifiedSubscription.products.service.PlanService;
import com.projectunifiedSubscription.products.service.ProductService;
import com.projectunifiedSubscription.products.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private PlanService planService;

    @Override
    public Subscription issueSubscription(SubscriptionDto subscriptionDto) {
        Optional<User> user = userRepo.findById(subscriptionDto.getUserId());
        if (user.isEmpty()) {
            throw new GenericException("User does not exists", HttpStatus.NOT_FOUND);
        }
        Optional<Plan> plan = planRepo.findById(subscriptionDto.getPlanId());
//        PlanData planData = planService.getById(subscriptionDto.getPlanId());
        Subscription subscription = new Subscription();
        subscription.setUser(user.get());
        subscription.setPlan(plan.get());
        subscription.setStartDate(subscriptionDto.getStartDate());
        subscription.setEndDate(subscriptionDto.getEndDate());
//        subscription.setPrice(subscription.getPrice());
        return subscriptionRepo.save(subscription);
    }

    @Override
    public List<Subscription> getUserSubscription(Long userId) {
       Optional<User> user = userRepo.findById(userId);
       if(user.isEmpty()){
           throw new GenericException("User does not exists", HttpStatus.NOT_FOUND);
       }
       return subscriptionRepo.findByUser(user.get());
    }
}
