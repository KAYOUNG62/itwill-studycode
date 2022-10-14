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

    // singleton 적용
    private static BlogDaoImpl instance = null;

    private BlogDaoImpl() {
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
        List<Blog> list = new ArrayList<>(); // 리턴하기 위한 ArrayList - select의 결과를 저장.

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection(); // 오라클 DB와 연결(접속)

            String sql = SQL_SELECT_ALL; // SQL 문장 준비
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(); // SQL 문장 실행

            while (rs.next()) { // ResultSet에 row 데이터가 있으면
                // row 에서 각 컬럼에 잇는 값들을 분석.
                Integer blogNo = rs.getInt(COL_BLOG_NO);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime createdDate = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();

                // 블로그 타임 객체 생성
                Blog blog = new Blog(blogNo, title, content, author, createdDate, modifiedDate);
                list.add(blog);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public Blog select(Integer blogNo) {
        Blog blog = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_NO);
            stmt.setInt(1, blogNo);

            rs = stmt.executeQuery();
            if (rs.next()) { // 검색 결과에서 row 데이터가 있으면
                Integer no = rs.getInt(COL_BLOG_NO);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime created = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();

                blog = new Blog(no, title, content, author, created, modified);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return blog;
    }

    @Override
    public int insert(Blog blog) {
        int result = 0; // DB insert 결과 값(insert된 행의 개수)을 저장할 변수

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setString(3, blog.getAuthor());

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public int update(Blog blog) {
        int result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setInt(3, blog.getBlogNo());
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int delete(Integer blogNO) {

        int result = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, blogNO);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public List<Blog> select(int type, String keword) {
        List<Blog> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();

            switch (type) {
            case 0: // 제목검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
                stmt.setString(1, "%" + keword.toLowerCase() + "%");
                break;
            case 1: // 내용 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
                stmt.setString(1, "%" + keword.toLowerCase() + "%");
                break;
            case 2: // 제목+내용
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
                stmt.setString(1, "%" + keword.toLowerCase() + "%");
                stmt.setString(2, "%" + keword.toLowerCase() + "%");
                break;
            case 3: // 작성자
                stmt = conn.prepareStatement(SQL_SELECT_BY_AUTHOR);
                stmt.setString(1, "%" + keword.toLowerCase() + "%");
                break;
            default:

            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                Integer blogNo = rs.getInt(COL_BLOG_NO);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime created = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
            
                Blog blog = new Blog(blogNo, title, content, author, created, modified);
                list.add(blog);
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}
