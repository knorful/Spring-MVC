package com.example.springmvcdemo.service;

import com.example.springmvcdemo.entity.User;
import com.example.springmvcdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String registerUser(User user) {
        userRepository.save(user);
        return "Registered User";
    }

    public Integer loginUser(String email, String password) {
        var foundUser = userRepository.findByEmailAndPassword(email, password);
        AtomicInteger loginId = new AtomicInteger();
        System.out.println("here it is = " + foundUser);
        foundUser
                .ifPresentOrElse(u -> loginId.set(u.getId()),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
        );

        return loginId.get();
    }

}
