package edu.java.list04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMain04 {

    public static void main(String[] args) {
        // User 타입 객체 선언, 생성, 출력
        // User 객체 콘솔 출력 값이 toString() 메서드 override 전 후에 어떻게 달라지는지
        User user = new User();
        System.out.println(user);

        // User 타입을 저장할 수 있는 ArrayList를 선언, 생성.
        // for 문장을 사용(3번 반복) Scanner 사용.
        // 콘솔창에서 입력받은 아이디와 비밀번호로 User 객체 생성
        // 리스트를 출력
        Scanner scan = new Scanner(System.in);

        List<User> userInfo = new ArrayList<>();

        String name;
        String pass;
        for (int i = 0; i < 3; i++) {
            System.out.print("아이디 입력>");
            name = scan.nextLine();
            System.out.print("비밀번호 입력>");
            pass = scan.nextLine();

            userInfo.add(new User(name, pass));
        }
        System.out.println(userInfo);
        
    }
}
