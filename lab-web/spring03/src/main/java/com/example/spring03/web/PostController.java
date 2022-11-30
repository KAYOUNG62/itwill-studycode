package com.example.spring03.web;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring03.domain.Post;
import com.example.spring03.dto.PostCreateDto;
import com.example.spring03.dto.PostUpdateDto;
import com.example.spring03.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/post")
public class PostController {
    
    private final PostService postService;
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/create")
    public void create() {
        log.info("create()");
        // 컨트롤러 메서드의 리턴 타입이 void 인 경우 뷰의 이름은 요청 주소와 같음
    }
    
    @PostMapping("/create") // Post 방식의 /post/create 요청을 처리하는 메서드.
    public String create(PostCreateDto dto, RedirectAttributes attrs) {
        log.info("create(dto={})" , dto);
        
        Post entity = postService.create(dto);
        
        // 작성된 포스트의 번호(id)를 redirect 되는 페이지로 전달
        attrs.addFlashAttribute("createdId", entity.getId());
        
        //PRG (Post-Redirect-Get) 패턴
        return "redirect:/";
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping({"/detail" , "/modify" })
    //컨트롤러 메서드가 2개 이상의 요청 주소를 처리할 때는 mapping에서 요청주소를 배열로 설정.
    public void detail(Integer id, Model model) {
        log.info("detail(id={})" , id);

        //요청파라미터 id를 번호로 갖는 포스트 내용을 검색 -> 뷰에 전달
        Post post = postService.read(id);
        
        model.addAttribute("post", post);
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/delete")
    public String delete(Integer id, RedirectAttributes attrs) {
        log.info("delete(id={})" , id);
        
        Integer postId = postService.delete(id);
        
        attrs.addFlashAttribute("deletedPostId", postId);
        
        // 삭제 완료 후 목록 페이지로 이동 -PRG 패턴 
        return "redirect:/";
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
        
        Integer postId = postService.update(dto);
        
        // 수정 성공 후 상세페이지
        return "redirect:/post/detail?id=" + dto.getId();
    }
    
    @GetMapping("/search")
    public String search(String type, String keyword, Model model) {
        log.info("search(type={}, keyword={}", type, keyword);
        
        List<Post> list = postService.search(type, keyword); 
        model.addAttribute("list",list);
        
        return "/post/list";
    }
    
}
