package edu.web.jsp02.service;

import java.util.List;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.dto.postUpdateDto;

public interface PostService {
    
    public List<Post> read(); // 포스트 전체 목록 읽어오기
    public int create(PostCreateDto dto); // 포스트 글 작성하기
    public Post readById(Integer id); // id(글번호)가 일치하는 포스트 1개 읽어오기
    public int delete(Integer id); // id가 일치하는 포스트 1개를 삭제
    public int update(postUpdateDto dto);
//    public int update(Post post, Integer id);
    public List<Post> search(String type, String keyword);
}
