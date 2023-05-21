package com.projectunifiedSubscription.products.service;

import com.projectunifiedSubscription.products.Registration.RegistrationRequest;
import com.projectunifiedSubscription.products.entity.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    User registerUser(RegistrationRequest request);

    Optional<User> findByEmail(String email);

    void saveUserVerificationToken(User user, String verificationToken);

    String validateToken(String token);
}
