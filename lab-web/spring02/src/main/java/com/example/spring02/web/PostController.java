package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring02.domain.Post;
import com.example.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller // 스프링 컨테이너가 Bean으로 생성, 관리, ( + servlet-context 에 component-scan 을 추가해야됨)
public class PostController {
    
    private final PostService postService; // 생성자에 의한 의존성 주입
    
    // 전체목록 
    @GetMapping("/post/list")
    public String list(Model model) {
        log.info("list()");
        List<Post> post = postService.read();
        model.addAttribute("post", post);
        return "/post/list";
    }
    //TODO 상세보기, 수정페이지, 수정/삭제 컨트롤러 메서드
    
    // 새글 작성 페이지로 이동
    @GetMapping("/post/create")
    public String createPage() {
        return "/post/create";
    }
    
    // 새글을 DB에 저장
    @PostMapping("/post/create")
    public String createInsert(String title, String content, String author, Post post) {
        log.info("createInsert()");
        
        post = Post.builder().title(title).content(content).author(author).build();
        postService.cteate(post);
        
        return "/post/create";
    }
    
    @GetMapping("/post/detail")
    public String detail(Integer id, Model model) {
        log.info("detail()");
        
        Post post = postService.readById(id);
        model.addAttribute("post" , post);
    
        return "/post/detail";
    }
    
    @GetMapping("/post/modify")
    public String modify(Integer id, Model model) {
        
        Post post = postService.readById(id);
        model.addAttribute("post" , post);
        
        return "/post/modify";
    }
    
    @PostMapping("/post/modify")
    public String modifyupdate() {
        
        
        return "/post/detail";
    }

}
