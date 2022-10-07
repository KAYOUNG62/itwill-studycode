package edu.java.ojdbc.controller;

import java.util.List;

import edu.java.ojdbc.model.Blog;

public interface BlogDao {
    
    List<Blog> select(); // SQL_SELECT_ALL
    
    Blog select(Integer blogNo); // SQL_SELECT_BY_NO  / Main1
    
    //int insert(String title, String content, String author); 
    int insert (Blog blog);// SQL_INSERT / Main2
    
    //int update(int no, String title, String content); 
    int update(Blog blog); // SQL_UPDATE / Main3
    
    int delete(Integer blogNO); // SQL_DELETE / Main4
}
