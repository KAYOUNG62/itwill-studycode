package com.example.spring02.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.domain.User;
import com.example.spring02.dto.UserCreateDto;
import com.example.spring02.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;
        
    @GetMapping("/userList")
    public String list(Model model) {
        List<User> list = userService.userList();
        
        model.addAttribute("list" , list);
        
        return "/user/userList";
    }
    
    
    @GetMapping("/signUp")
    public String signUp() {
        log.info("signUp()");
        return "/user/signUp";
    }

    @PostMapping("/signUp")
    public String signUP(UserCreateDto dto) {
        log.info("signUp(dto={}", dto);

        userService.signUp(dto);
        return "/user/signIn";
    }
    
    @GetMapping("/signIn")
    public String signIn() {
        log.info("signIn");
        return "/user/signIn";
    }
    
    @PostMapping("/signIn")
    public String signIn(String username, String password, HttpSession session) {
        log.info("signIn(username={}, password={}", username, password);
        
        userService.signInUsername(username, password);
        
        session.setAttribute("signInUser", username);
        
        return "/post/list";
    }
    
    @GetMapping()
    public String signOut(HttpSession session) {
        log.info("signOut()");
        
        session.removeAttribute("signInUser");
        session.invalidate();
        
        return "/";
    }
    
    

}
