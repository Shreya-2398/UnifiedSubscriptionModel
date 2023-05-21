package com.projectunifiedSubscription.products.Registration;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String role) {
        }