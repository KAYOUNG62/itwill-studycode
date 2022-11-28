package com.example.spring03.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity(name="MEMBERS")
@SequenceGenerator(name = "MEMBERS_SEQ_GEN", sequenceName = "MEMBERS_SEQ" , allocationSize = 1)
public class Member extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBERS_SEQ_GEN")
    private Integer id; // Primary Key
    
    @Column(unique = true , nullable = false) // unique, not null
    private String username; // 사용자 (로그인) 아이디. userId, memberId
    
    @Column(nullable = false)
    private String password; // 사용자 비밀번호
    
    @Column(nullable = false)
    private String email; // 사용자 이메일 정보 > social 로그인 기능에서 사용될 수 있음.

    private String nickname;
    

    private boolean deleted; // 탈퇴 여부
    
    private boolean social; // social login 여부
    
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default 
    // builder 패턴으로 객체를 생성할 때, roles() 메서드를 호출하지 않으면
    // null 대신 클래스의 필드 선언에서 생성된 객체가 사용되도록 하기 위해 Builder.Default 사용
    private Set<MemberRole> roles = new HashSet<>();
    
    public Member addRole(MemberRole role) {
        roles.add(role);
        return this;
    }
}
