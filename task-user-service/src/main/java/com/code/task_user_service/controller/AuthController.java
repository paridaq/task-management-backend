package com.code.task_user_service.controller;

import com.code.task_user_service.repository.UserRepository;
import com.code.task_user_service.service.CustomerUserServiceImplementaion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthController {

    @Autowired
    private UserRepository userRepository;
     @Autowired
    private PasswordEncoder passwordEncoder;

     @Autowired
    private CustomerUserServiceImplementaion customerUserDetails;

}
