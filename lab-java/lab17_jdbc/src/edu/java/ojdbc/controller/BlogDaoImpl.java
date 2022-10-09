package edu.java.ojdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.java.ojdbc.model.Blog;
import oracle.jdbc.OracleDriver;

import static edu.java.ojdbc.model.Blog.Entity.*;
import static edu.java.ojdbc.controller.JdbcSql.*;
import static edu.java.ojdbc.OracleJdbc.*;

public class BlogDaoImpl implements BlogDao {
    
    //singleton 적용
    private static BlogDaoImpl instance = null;
    private BlogDaoImpl () {
    }
    public static BlogDaoImpl getInstance() {
        if (instance == null) {
            instance = new BlogDaoImpl();
        }
        return instance;
    }
    
    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    private void closeResources(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
    }
    
    
    @Override
    public List<Blog> select() {
        List<Blog> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            String sql = String.format("select * from %s order by %s desc" , TBL_BLOGS, COL_BLOG_NO);
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Integer blogNo = rs.getInt(COL_BLOG_NO);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime createdDate = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                Blog blog = new Blog(blogNo, title, content, author, createdDate, modifiedDate);
                list.add(blog);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                closeResources (conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }

    @Override
    public Blog select(Integer blogNo) {
        // TODO Auto-generated method stub
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            String sql = SQL_SELECT_BY_NO;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, COL_BLOG_NO);
            
            stmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn,stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
           
        return select(blogNo);
    }

    @Override
    public int insert(Blog blog) {
        //TODO
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            String sql = SQL_INSERT;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, COL_TITLE);
            stmt.setString(2, COL_CONTENT);
            stmt.setString(3, COL_AUTHOR);
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn,stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return 1;
    }


    @Override
    public int update(Blog blog) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            String sql = SQL_UPDATE;
            stmt = conn.prepareStatement(sql);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
        
        return 1;
    }

    @Override
    public int delete(Integer blogNO) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            String sql = SQL_DELETE;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, blogNO);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources (conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return 1;
    }
    
    

}
