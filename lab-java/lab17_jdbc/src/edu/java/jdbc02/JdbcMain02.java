package edu.java.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static edu.java.ojdbc.OracleJdbc.*;
import static edu.java.ojdbc.model.Blog.Entity.*;


public class JdbcMain02 {

    public static void main(String[] args) {
        // JDBC를 이용한 insert
        
        Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        
        try {
            // 라이브러리 관리자에게 오라클 라이브러리를 등록 - 메모리 로딩
            DriverManager.registerDriver(new OracleDriver());
            
            // 라이브러리 관리자를 이용해서 데이터베이스와 연결
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // SQL 문장
            String sql = String.format("insert into %s(%s, %s, %s) values (?, ?, ?)",  // PreparedStatement의 파라미터는 ?로 처리함
                    TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_AUTHOR );
            System.out.println(sql);
            
            //PreparedStatement
            stmt = conn.prepareStatement(sql);
             
            // 콘솔창에서 블로그 글 제목, 내용, 작성자를 입력
            // 아래 입력문장을 SQL 문장 위쪽으로 올려서 작성시 setString을 넣을 필요는 없음.
            System.out.print("제목 입력>> ");
            String title = scanner.nextLine();
            System.out.print("내용 입력>> ");
            String content = scanner.nextLine();
            System.out.print("작성자>> ");
            String author = scanner.nextLine();
            
            // PreparedStatement 객체에 입력받은 값들을 설정: 
            stmt.setString(1, title); // stmt 에서 첫번째 ?를 변수 title 값으로 대체. , sql과 관련되면 인덱스가 0이 아닌 1부터 시작함.
            stmt.setString(2, content); // stmt 에서 두번째 ?를 변수 content 값으로 대체.
            stmt.setString(3, author); // stmt 에서 세번째 ?를 변수 author 값으로 대체.
            
            // SQL 문장 실행
            int result = stmt.executeUpdate();
            // 실행 결과 출력
            System.out.println(result + "개 행이 삽입됐습니다.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
