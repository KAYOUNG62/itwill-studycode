package com.example.spring03.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring03.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTest2 {
    
    @Autowired
    private PostRepository postRepository;
    
//    @Test
//    public void testUpdate() {
//        // DB table update : 
//        // (1) id로 수정할 엔터티 검색, (2) 엔터티를 수정, (3) 수정한 엔터티를 postRepository.save(entity) 메서드 호출
//        Post entity = postRepository.findById(1).get(); 
//        log.info("수정 전 : {} | {} | {}" , entity, entity.getCreatedTime(), entity.getModifiedTime());
//        
//        entity.update("update 테스트", "Spring Data JPA를 사용한 DB table update");
//        log.info("수정 후 : {} | {} | {} ", entity, entity.getCreatedTime(), entity.getModifiedTime());
//        
//        postRepository.save(entity); // DB에 수정 내용을 반영(select -> update -> commit)
//        log.info("sava 후 : {} | {} | {} ", entity, entity.getCreatedTime(), entity.getModifiedTime());
//    }

    @Test
    public void testDelete() {
        // delete from POSTS where ID = 25
        postRepository.deleteById(25);
    }
    

}
