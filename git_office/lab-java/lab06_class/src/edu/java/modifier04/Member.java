package edu.java.modifier04;

/* 연습문제 
 * field : 아이디String, 비밀번호String
 * constructor : argument 2개를 갖는 생성자.
 * method : 아이디 getter, 비밀번호 getter/setter
 */

public class Member {
    private String id;
    private String password;
    
    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }

}
