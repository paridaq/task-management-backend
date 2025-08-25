package com.code.task_user_service.service;


import com.code.task_user_service.modal.User;
import com.code.task_user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUserServiceImplementaion implements UserDetailsService {

    @Autowired
    //request the bean form the spring container
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("user not found with email"+username);

        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return  new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);

    }
}
