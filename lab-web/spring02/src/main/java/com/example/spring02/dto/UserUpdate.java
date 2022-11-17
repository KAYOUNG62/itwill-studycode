package com.example.spring02.dto;

import com.example.spring02.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdate {
    
    private Integer id;
    private String password;
    private String email;
    
    public User toEntity() {
        return User.builder().id(id).password(password).email(email).build();
                
    }
    

}
