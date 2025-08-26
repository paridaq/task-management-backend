package com.code.task_user_service.service;

import com.code.task_user_service.modal.User;

import java.util.List;

public interface UserService {

    public User getUserProfile(String jwt);

    public List<User> getAllUsers();
}
