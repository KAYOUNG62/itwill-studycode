package com.example.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.Post;
import com.example.spring02.mapper.PostMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드를 argument로 갖는 생성자를 만들어줌
@Service
// @Service + applicationContext.xml 스프링 컨테이너에 서비스 컴포넌트로 등록.
// 스프링 컨테이너가 필요한곳(예:컨트롤러 객체)에 Service 컴포넌트를 주입할 수 있음 
public class PostService {

    // 의존성 주입 방법(dependency inject) :
    // (1) 필드에 의한 의존성 주입 : @Autowired
    //  - @Autowired private PostMapper postMapper; 

    // (2) 생성자에 의한 의존성 주입 : final 필드 + Required-Args 생성자
    private final PostMapper postMapper;
    
    public List<Post> read(){
        return postMapper.selectOrderByIdDesc();
    }
    
    public Post readById(Integer id) {
        return postMapper.selectById(id);
    }
    
    public Integer cteate(Post entity) {
        return postMapper.insert(entity);
    }
    
    public Integer update(Post entity) {
        return postMapper.updateById(entity);
    }
    
    public Integer delete(Integer id) {
        return postMapper.deleteById(id);
    }
    
    // 새글작성, 글번호검색, 수정, 삭제서비스

}
