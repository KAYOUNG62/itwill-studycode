package com.example.spring02.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.User;
import com.example.spring02.dto.UserCreateDto;
import com.example.spring02.dto.UserUpdate;
import com.example.spring02.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    
    public List<User> userList(){
        return userMapper.selectUser();
    }
    
    public Integer signUp(UserCreateDto dto) {
        log.info("signUp(dto={})", dto);
        return userMapper.userInsert(dto.toEntity());
    }

    public User signIn(String username, String password) {
        log.info("signIn(username={}, password={})", username, password);
        User user = User.builder().username(username).password(password).build();

        return userMapper.selectByUserId(user);
    }
    
    public Integer userUpdate(UserUpdate dto) {
        log.info("userUpdate()");

        return userMapper.userUpdate(dto.toEntity());
    }

    public Integer userDelete(Integer id) {
        log.info("userDelete(id={}", id);

        return userMapper.userDelete(id);
    }
    
    public User signInUsername(String username, String password) {
        
        return userMapper.userSignIn(username, password);
    }
    

}
