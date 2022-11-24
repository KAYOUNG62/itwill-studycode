package com.example.spring03.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor // Entity 클래스는 반드시 기본생성자가 있어야됨
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = {"post"}) // toString() 만들때 제외할 필드(post) 설정
@Entity(name="REPLIES") // 테이블명 replies에 매핑되는 엔터티 클래스
//initialValue 는 기본값이 1이기 때문에 설정해줄 필요 없음
@SequenceGenerator(name="REPLIES_SEQ_GEN",sequenceName = "REPLIES_SEQ", allocationSize = 1)
public class Reply extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "REPLIES_SEQ_GEN")
    private Integer id; // 댓글번호 -PK
    
    // FetchType.LAZY > 다대일 관계(relation)
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post; // 댓글이 달린 포스트- Foreign Key
    
    @Column(nullable = false, length = 1000) // Not Null 제약조건, 문자열 길이 지정
    private String replyText; // 댓글내용
    
    @Column(nullable = false)
    private String writer; // 댓글 작성자
    
    // 댓글 수정에서 사용할 메서드 (setter 메서드 대신 사용할 메서드) 
    public Reply update(String replyText) { 
        this.replyText = replyText;
        return this;
    }
    
}
