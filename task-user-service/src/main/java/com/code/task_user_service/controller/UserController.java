package com.code.task_user_service.controller;


import com.code.task_user_service.modal.User;
import com.code.task_user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

@Autowired
    private UserService userService;

// requestbody anotaion is for take the json and convert to java object to the further operations
    // requestheader is extract the value from the http request header .
    //pathvariable is for getting the value from the url parameter

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt){
        User user=userService.getUserProfile(jwt);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(@RequestHeader("Authorization")String jwt){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
        //so if one token is valid (token of any user ) then spring allow the furthr operation so we just need any valid token to do that
    }


}
