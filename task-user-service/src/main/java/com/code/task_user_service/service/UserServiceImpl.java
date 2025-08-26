package com.code.task_user_service.service;

import com.code.task_user_service.config.JwtProvider;
import com.code.task_user_service.modal.User;
import com.code.task_user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
@Autowired
private UserRepository userRepository;

    @Override
    public User getUserProfile(String jwt) {
        String email = JwtProvider.getEmailFromJwtToken(jwt);
        return userRepository.findByEmail(email);

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
