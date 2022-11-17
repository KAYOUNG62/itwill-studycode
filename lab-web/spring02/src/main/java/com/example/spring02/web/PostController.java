package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostCreateDto;
import com.example.spring02.dto.PostSearchDto;
import com.example.spring02.dto.PostUpdateDto;
import com.example.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller // 스프링 컨테이너가 Bean으로 생성, 관리, ( + servlet-context 에 component-scan 을 추가해야됨)
@RequestMapping("/post") 
// -> 클래스에 @RequestMapping 애너테이션을 사용하면, 
//    그 클래스의 모든 메서드들의 매핑 주소는 @RequestMapping에서 설정된 URL로 시작 
public class PostController {
    
    private final PostService postService; // 생성자에 의한 의존성 주입
    
    // 전체목록  
    @GetMapping("/list")
    public String list(Model model) {
        log.info("list()");
        //Sevice 계층의 메서드를 사용해서 포스트 전체 목록을 검색함.
        List<Post> list = postService.read();
        
        //포스트 목록을 뷰에 전달하기 위해서 model을 이용
        model.addAttribute("list", list);
        
        return "/post/list"; // /WEB-INF/views/post/list.jsp
    }
    
    // 새글 작성 페이지로 이동
    @GetMapping("/create")
    public String create() {
        log.info("create()");
        
        return "/post/create";
    }
    
    // 새글을 DB에 저장
    @PostMapping("/create")
    public String create(PostCreateDto dto) {
        log.info("create(dto={})",dto);
        
        // 서비스 계층의 메서드를 호출해서 포스트 작성 내용을 DB에 저장.
        postService.cteate(dto);
        
        // 포스트 목록 페이지로 이동(redirect) :PRG(Post - Redirect - Get) 패턴
        return "redirect:/post/list";
    }
    
    @GetMapping("/detail")
    public String detail(Integer id, Model model) {
        log.info("detail(id={})", id);
        
        Post post = postService.readById(id);
        model.addAttribute("post", post);
        
        return "/post/detail";
    }
    
    @GetMapping("/modify")
    public String modify(Integer id, Model model) {
        log.info("modify(id={})",id);
        
        Post post = postService.readById(id);
        model.addAttribute("post", post);
        
        return "/post/modify";
    }
    
    @PostMapping("/delete")
    public String delete(Integer id) {
        log.info("delete(id={})" ,id);
        
        postService.delete(id);
        
        return "redirect:/post/list";
    }
    
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
        log.info("update(dto={})" , dto);
        
        postService.update(dto);
        
        return "redirect:/post/detail?id=" + dto.getId();
    }
    
    @GetMapping("/search")
    public String search(PostSearchDto dto, Model model) {
        log.info("search(dto={})", dto);
        
        //검색 서비스를 수행
        List<Post> result = postService.search(dto);
        model.addAttribute("list" , result);
        
        return "/post/list";
    }

}
