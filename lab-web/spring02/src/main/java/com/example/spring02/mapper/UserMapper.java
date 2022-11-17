package com.example.spring02.mapper;


import java.util.List;

import com.example.spring02.domain.User;

public interface UserMapper {
    
    List<User> selectUser();
    
    User selectByUserId(User user);
    
    int userInsert(User Entity);

    int userUpdate(User Entity);
    
    int userDelete(Integer id);
    
    User userSignIn(String username, String password);
    
}
