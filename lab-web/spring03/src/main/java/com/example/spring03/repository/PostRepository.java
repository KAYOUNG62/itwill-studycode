package com.example.spring03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring03.domain.Post;

// JpaRepository<엔터티 클래스의 타입, PK 데이터 타입> 을 상속하는 인터페이스를 선언만하면됨
// -> 기본적인 CRUD(Create, Read, Update, Delete)에 필요한 메서드들이 자동으로 생성
// -> JpaRepository 를 상속하는 인터페이스는 스프링 컨텍스트에서 bean 으로 자동으로 관리됨
// -> @Repository 가 필요없음
public interface PostRepository extends JpaRepository<Post, Integer>{
    
    // select * from POSTS order by ID desc
    List<Post> findByOrderByIdDesc();
    
    
}
