package com.blog_app.user_app.controller;

import com.blog_app.user_app.reponse.UserResponse;
import com.blog_app.user_app.request.UserRequest;
import com.blog_app.user_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void createUser(@RequestBody UserRequest userRequest) {
        service.createUser ( userRequest );
    }

    @GetMapping("/findById/{userId}")
    public UserResponse findById(@PathVariable Long userId){
        return service.findById(userId);
    }
@GetMapping("/")
    public List<UserResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("/isUserExist/{userId}")
    public Boolean findUserId(@PathVariable Long userId){
        return service.findUser(userId);
    }

}
