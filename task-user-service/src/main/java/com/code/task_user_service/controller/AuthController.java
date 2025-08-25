package com.code.task_user_service.controller;

import com.code.task_user_service.modal.User;
import com.code.task_user_service.repository.UserRepository;
import com.code.task_user_service.response.AuthResponse;
import com.code.task_user_service.service.CustomerUserServiceImplementaion;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthController {

    @Autowired
    private UserRepository userRepository;
     @Autowired
    private PasswordEncoder passwordEncoder;

     @Autowired
    private CustomerUserServiceImplementaion customerUserDetails;

     @PostMapping("/signup")

    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws Exception{
         String email = user.getEmail();
                 String password = user.getPassword();
                 String fullName = user.getFullName();


     }

}
