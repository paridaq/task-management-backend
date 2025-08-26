package com.code.task_user_service.controller;

import com.code.task_user_service.config.JwtProvider;
import com.code.task_user_service.modal.User;
import com.code.task_user_service.repository.UserRepository;
import com.code.task_user_service.request.LoginRequest;
import com.code.task_user_service.response.AuthResponse;
import com.code.task_user_service.service.CustomerUserServiceImplementaion;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

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

                 String role = user.getRole();
                 User isEmailExist = userRepository.findByEmail(email);
                 if(isEmailExist!=null){
                     throw new Exception("Email is already in use with another account");
                 }
                 User createdUser = new User();
                 createdUser.setEmail(email);
                 createdUser.setFullName(fullName);
                 createdUser.setRole(role);
                 createdUser.setPassword(passwordEncoder.encode(password));

                 User savedUser = userRepository.save(createdUser);





            Authentication authentication = new UsernamePasswordAuthenticationToken(email,password);
            // create a login token using email and password
         SecurityContextHolder.getContext().setAuthentication(authentication);
         // store the token inside spring security contexts,so the user is now considered loggedIn for ths current session/request.



         String token = JwtProvider.generateToken(authentication);
         AuthResponse authResponse = new AuthResponse();
         authResponse.setJwt(token);
         authResponse.setMessage("Register successfully");
         authResponse.setStatus(true);

         return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);





     }

     @PostMapping("/signin")
    public ResponseEntity<AuthResponse>signIn(@RequestBody LoginRequest loginRequest){

         String username = loginRequest.getEmail();
         String password = loginRequest.getPassword();
         System.out.println(username+ "======"+password);
         Authentication authentication = authenticate(username,password);
         SecurityContextHolder.getContext().setAuthentication(authentication);

         String token = JwtProvider.generateToken(authentication);
         AuthResponse authResponse = new AuthResponse();
         authResponse.setMessage("login successful");
         authResponse.setJwt(token);
         authResponse.setStatus(true);
         return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK);
     }


     private Authentication authenticate(String username,String password){
         UserDetails userDetails = customerUserDetails.loadUserByUsername(username);
         System.out.println("singin with userDetails"+userDetails);

         if(userDetails==null){
             System.out.println("signin with userDetails"+userDetails);
             throw new BadCredentialsException("Invalid username or password");

         }
         if(!passwordEncoder.matches(password,userDetails.getPassword())){
             System.out.println("singin in userdetails = password not match"+userDetails);
             throw new BadCredentialsException("Invalid username or password");
         }
         return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
     }


}
