package edu.java.ojdbc;

public interface OracleJdbc {
    
    // Oracle DB에 접속하는 주소(, 포트번호, SID)
    // 자바:오라글(혹은 MYSQL):오라클접속명령어:@아이피주소:포트번호:SID
    // 오라클 들어가서 접속이름선택(study) > 속성 > 세부정보에 있는 정보 사용
    // interface에서 선언하는 변수는 public static finally 변수이지만 생략만 되어있을 뿐
    //String URL ="jdbc:oracle:thin:@192.168.20.31:1521:xe"; >
    String URL ="jdbc:oracle:thin:@localhost:1521:xe";
    
    //Oracle DB에 접속하는 사용자 계정
    String USER = "scott";
    
    //Oracle DB에 접속하는 사용자 비밀번호
    String PASSWORD = "tiger";
    

}
