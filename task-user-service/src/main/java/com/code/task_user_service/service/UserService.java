package com.code.task_user_service.service;

import com.code.task_user_service.modal.User;

public interface UserService {

    public User getUserProfile(String jwt);
}
