package edu.web.jsp02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.Post;

//MVC 아키텍쳐에서 Controller의 계층들 중에서 DB 관련 작업을 수행하는 계층.
//Controller 계층: Web layer(Servlet) - Service layer - Repository layer(DAO)
public class PostDaoImpl implements PostDao {
    // Slf4j로그를 사용하기 위해서
    private static final Logger log = LoggerFactory.getLogger(PostDaoImpl.class);

    private static PostDaoImpl instance = null;
    private HikariDataSource ds;

    private PostDaoImpl() {
        ds = HikariDataSourceUtil.getInstance().getDataSource();
    }

    public static PostDaoImpl getInstance() {
        if (instance == null) {
            instance = new PostDaoImpl();
        }
        return instance;
    }

    public static final String SQL_SELECT = "select * from POSTS order by ID desc";

    @Override
    public List<Post> select() {
        log.info("select()"); // 메서드 이름
        log.info("SQL:{}", SQL_SELECT); // 메서드에서 실행할 SQL 문장

        List<Post> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection(); // Connection Pool(Data Source)에서 Connection을 빌려옴.
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) { // select 결과에서 row 데이터가 있으면
                Integer id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String content = rs.getString("CONTENT");
                String author = rs.getString("AUTHOR");
                LocalDateTime createdTime = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
                LocalDateTime modifiedTime = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();

                Post post = Post.builder().id(id).title(title).content(content).author(author).createdTime(createdTime)
                        .modifiedTimr(modifiedTime).build();
                list.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close(); // Data Source 에서 빌려온 Connection을 반환.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static final String SQL_INSERT = "insert into POSTS(TITLE, CONTENT, AUTHOR, CREATED_TIME, MODIFIED_TIME) "
            + "values(?, ?, ?, sysdate, sysdate)";

    @Override
    public int insert(Post entity) {
        log.info("insert(entity={})", entity);
        log.info(SQL_INSERT);

        int result = 0; // DB에 insert 성공했을 때 시퀀스로 생성된 글 번호

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, entity.getTitle());
            stmt.setString(2, entity.getContent());
            stmt.setString(3, entity.getAuthor());

            result = stmt.executeUpdate(); // insert된 행의 개수를 리턴
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
