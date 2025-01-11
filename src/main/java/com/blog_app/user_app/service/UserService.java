package com.blog_app.user_app.service;

import com.blog_app.user_app.model.User;
import com.blog_app.user_app.reponse.UserResponse;
import com.blog_app.user_app.repository.UserRepository;
import com.blog_app.user_app.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(UserRequest userRequest) {
        User user = new User ( );
        user.setEmail ( userRequest.getEmail ( ) );
        user.setName ( userRequest.getName ( ) );
        user.setPassword ( userRequest.getPassword ( ) );
        repository.save(user);
    }

    public UserResponse findById(Long userId) {
        return new UserResponse( repository.findById ( userId ).orElseThrow ( () -> new RuntimeException ( "id not found" ) ));
    }

    public List<UserResponse> findAll() {
        return repository.findAll ( ).stream ( ).map ( UserResponse::new ).toList ( );
    }

    public Boolean findUser(Long userId)  {
               return repository.existsById ( userId );
    }
}
