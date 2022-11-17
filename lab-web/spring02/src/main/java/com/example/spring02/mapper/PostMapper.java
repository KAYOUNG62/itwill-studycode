package com.example.spring02.mapper;

import java.util.List;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostSearchDto;
import com.example.spring02.service.PostService;

// MyBatis 프레임워크에서 매퍼 인터페이스를 구현하는 클래스를 생성
// MyBatis 프레임워크에서 매퍼 인터페이스를 찾을 수 있도록 applicationContext.xml에서
// <mybatis:scan> 설정을 해줌 
// 매퍼 인터페이스가 사용할 SQL 문장들을 정의한 xml 파일(post-mapper.xml)을 작성
public interface PostMapper {
    
    List<Post> selectOrderByIdDesc();
    
    Post selectById(Integer id);
    
    int insert(Post entity);
    
    int updateById(Post entity);
    
    int deleteById(Integer id);
    
    List<Post> searchByKeyword(PostSearchDto dto);

}
