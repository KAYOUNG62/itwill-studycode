package edu.web.jsp02.domain;

import java.time.LocalDateTime;

//MVC 아키텍쳐에서 - Model에 해당하는 클래스. DB의 POSTS 테이블의 내용. 
//Model 클래스: (1) 필드, (2) 생성자, (3) getters, (4)toString
public class Post {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public Post() {
    }

    public Post(Integer id, String title, String content, String author, LocalDateTime createdTime,
            LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createdTime="
                + createdTime + ", modifiedTime=" + modifiedTime + "]";
    };
    
    //Builder(Factory) 패턴
    public static PostBuilder builder() {
        return new PostBuilder();
    }
    
    public static class PostBuilder {
        private Integer id;
        private String title;
        private String content;
        private String author;
        private LocalDateTime createdTime;
        private LocalDateTime modifiedTime;
        
        public PostBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public PostBuilder title(String title) {
            this.title = title;
            return this;
        }
        
        public PostBuilder content(String content) {
            this.content = content;
            return this;
        }
        
        public PostBuilder author(String author) {
            this.author = author;
            return this;
        }
        
        public PostBuilder createdTime(LocalDateTime createdTime) {
            this.createdTime = createdTime;
            return this;
        }
        
        public PostBuilder modifiedTimr(LocalDateTime modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;
        }
        
        public Post build() {
            return new Post(id, title, content, author, createdTime, modifiedTime);
        }
    }
    


}
