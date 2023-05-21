package com.projectunifiedSubscription.products.controller;

import com.projectunifiedSubscription.products.dto.SubscriptionDto;
import com.projectunifiedSubscription.products.entity.User;
import com.projectunifiedSubscription.products.service.SubscriptionService;
import com.projectunifiedSubscription.products.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping(path = "/getUsers")
    public List<User> getUsers() {

        return userService.getUsers();
    }
}

