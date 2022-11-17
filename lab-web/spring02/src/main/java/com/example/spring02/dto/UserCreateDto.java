package com.example.spring02.dto;

import com.example.spring02.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserCreateDto {
    
    private String username;
    private String password;
    private String email;
    
    public User toEntity() {
        return User.builder().username(username).password(password).email(email).build();
                
    }
    
    

}
