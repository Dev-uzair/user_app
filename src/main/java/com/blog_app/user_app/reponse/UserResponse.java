package com.blog_app.user_app.reponse;

import com.blog_app.user_app.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long userId;
    private String name;
    private String password;
    private String email;

    public UserResponse(User user) {
        this.userId = user.getUserId ();
        this.name = user.getName ();
        this.password = user.getPassword ( );
        this.email = user.getEmail ();
    }
}
