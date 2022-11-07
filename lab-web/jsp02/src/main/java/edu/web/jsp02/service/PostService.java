package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;

public interface PostService {
    
    public List<Post> read(); // 포스트 전체 목록 읽어오기
    public int create(PostCreateDto dto); // 포스트 글 작성하기
    
    
}
