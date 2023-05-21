package com.projectunifiedSubscription.products.controller;

import com.projectunifiedSubscription.products.Registration.RegistrationRequest;
import com.projectunifiedSubscription.products.entity.User;
import com.projectunifiedSubscription.products.repository.VerificationTokenRepo;
import com.projectunifiedSubscription.products.service.UserService;
import com.projectunifiedSubscription.products.entity.VerificationToken;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private VerificationTokenRepo tokenRepo;

    private String applicationUrl;

    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request){
        User user = userService.registerUser(registrationRequest);
        String verificationToken = UUID.randomUUID().toString();
        userService.saveUserVerificationToken(user, verificationToken);
        String url = applicationUrl(request)+"/register/verifyEmail?token="+verificationToken;
        log.info("Click the link to verify your registration :  {}", url);
        return "Success!  Please, check your email for to complete your registration";
    }

    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
        VerificationToken theToken = tokenRepo.findByToken(token);
        if (theToken.getUser().isEnabled()){
            return "This account has already been verified, please, login.";
        }
        String verificationResult = userService.validateToken(token);
        if (verificationResult.equalsIgnoreCase("valid")){
            return "Email verified successfully";
        }
        return "Invalid verification token";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}

