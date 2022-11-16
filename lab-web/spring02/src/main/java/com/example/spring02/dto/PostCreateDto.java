package com.example.spring02.dto;

import com.example.spring02.domain.Post;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data // = @RequiredArgsContructor + @Getter + @Setter + @ToString + @EqualsAndHashCode

// 포스트 작성 페이지에서 보낸 요청 파라미터들을 저장하고 서비스 계층으로 전달하기 위한 목적.
public class PostCreateDto {
    
    // 요청파라미터의 name 과 같게 설정
    private String title;
    private String content;
    private String author;
    
    //DTO 객체를 Entity 객체로 변환해서 리턴하는 매서드.
    public Post toEntity() {
        return Post.builder().title(title).content(content).author(author).build();
    }

}
