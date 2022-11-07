package edu.web.jsp02.repository;

import java.util.List;

import edu.web.jsp02.domain.Post;

public interface PostDao {
    
    public List<Post> select();
    
    public int insert(Post entity);

}
