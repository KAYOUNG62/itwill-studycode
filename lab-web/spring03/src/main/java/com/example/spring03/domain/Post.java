package com.example.spring03.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
// 클래스 이름과 DB테이블 이름이 다르면 반드시 name 속성을 지정.
// Entity 클래스는 반드시 Primary Key(고유키)가 있어야됨
@Entity(name="POSTS")
@SequenceGenerator(name="POSTS_SEQ_GEN", sequenceName = "POSTS_SEQ1", initialValue = 1, allocationSize = 1)
// Oracle의 시퀀스 객체를 고유키 생성에 사용하기 위해서
public class Post extends BaseTimeEntity {
    // 엔터티 클래스에서 @MappedSuperClass로 설정된 클래스를 상속하면
    // 상위 클래스의 필드들도 테이블의 컬럼으로 작성됨
    
    
    @Id // Primary Key(고유키)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTS_SEQ_GEN")
    private Integer id;
    
    @Column(nullable = false) // Not Null 제약조건
    private String title;
    
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;
    
    public Post update(String title, String content) {
        this.title = title;
        this.content = content;
        
        return this;
    }
    
}
