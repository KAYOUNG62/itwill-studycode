package edu.java.modifier04;

public class ModifierMain04 {

    public static void main(String[] args) {

        Member m = new Member("hong", "1234");
        System.out.println(m);
        System.out.println("아이디 : " + m.getId());
        System.out.println("비밀번호 : " + m.getPassword());

        m.setPassword("!@#$");
        System.out.println("변경된 비밀번호 : " + m.getPassword());
    }

}
