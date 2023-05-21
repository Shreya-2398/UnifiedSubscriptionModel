package com.projectunifiedSubscription.products.service.Implementations;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.Registration.RegistrationRequest;
import com.projectunifiedSubscription.products.entity.User;
import com.projectunifiedSubscription.products.repository.UserRepo;
import com.projectunifiedSubscription.products.repository.VerificationTokenRepo;
import com.projectunifiedSubscription.products.service.UserService;
import com.projectunifiedSubscription.products.entity.VerificationToken;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VerificationTokenRepo tokenRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {

        return userRepo.findAll();
    }
    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User> user = this.findByEmail(request.email());
        if(user.isPresent()){
            throw new GenericException("User already exists", HttpStatus.CONFLICT);
        }
        User newUser = new User();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setRole(request.role());
        return userRepo.save(newUser);
    }
    @Override
    public Optional<User> findByEmail(String email) {

        return userRepo.findByEmail(email);
    }

    @Override
    public void saveUserVerificationToken(User user, String verificationToken) {
        VerificationToken verificationToken1 = new VerificationToken(verificationToken,user);
        System.out.println(verificationToken1);
        tokenRepo.save(verificationToken1);
    }

    @Override
    public String validateToken(String theToken) {
        VerificationToken token = tokenRepo.findByToken(theToken);
        if(token == null){
            return "Invalid verification token";
        }
        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
            tokenRepo.delete(token);
            return "Token already expired";
        }
        user.setEnabled(true);
        userRepo.save(user);
        return "valid";
    }
}
