package edu.web.jsp01.domain;

import java.time.LocalDateTime;

public class Post {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createTime;
    
    // 기본생성자
    public Post() {};
    
    // argument 생성자
    public Post(Integer id, String title, String content, LocalDateTime createTime) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    
    // getter/ setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    } 
    
    // to string
    @Override
    public String toString() {
        return String.format("Post(id=%d, title=%s, content=%s, createTime=%s)", id, title, content, createTime  );
    }
    

}
