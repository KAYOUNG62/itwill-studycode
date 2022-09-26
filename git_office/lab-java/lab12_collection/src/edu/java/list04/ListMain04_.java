package edu.java.list04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListMain04_ {

    public static void main(String[] args) {
        // User 타입 객체 선언, 생성, 출력
        // User 객체 콘솔 출력 값이 toString() 메서드 override 전 후에 어떻게 달라지는지
        User user1 = new User();
        System.out.println(user1);
        user1.setUserId("hong");
        user1.setPassword("123");
        System.out.println(user1);

        // User 타입을 저장할 수 있는 ArrayList를 선언, 생성.
        // for 문장을 사용(3번 반복) Scanner 사용.
        // 콘솔창에서 입력받은 아이디와 비밀번호로 User 객체 생성
        // 리스트를 출력
        Scanner scan = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("아이디 입력> ");
            String id = scan.nextLine();
            System.out.print("비밀번호 입력> ");
            String qw = scan.nextLine();

            User user = new User(id, qw);
            users.add(user);
        }
        System.out.println(users);

        // 리스트 users에서 인덱스 1인 원소를 삭제, 리스트를 출력.
        users.remove(1);
        System.out.println(users);

        // 리스트에서 userId가 "guest"인 User 객체를 삭제, 리스트를 출력

//        System.out.print("삭제할 이름 입력> ");
//        String na = scan.nextLine();
//        for (int i = 0; i <users.size(); i++) {
//            if(na.equals(na)) {
//                users.remove(i);
//            }
//        }

//         방법 1) userId가 "guest"인 User 객체의 인덱스를 찾아서 삭제
//        for (int i = 0; i < users.size(); i++) {
//            // 두개의 문자열이 같은지 비교할때는 반드시 equals() 메서드를 사용
//            if (users.get(i).getUserId().equals("guest")) {
//                users.remove(i);
//                break;
//            }
//        }

        // 방법 2) userId가 "guest 인 User 객체를 찾아서 삭제 , 첫번째 guest만 삭제
        for (User u : users) {
            if (u.getUserId().equals("guest"))
                ;
            users.remove(u);
            break;
        }

        // 방법 3) guest 객체 전부 삭제
//        System.out.println(users);
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getUserId().equals("guest")) {
//                users.remove(i);
//                i--;
//            }
//        }
        System.out.println(users);
        
        System.out.println("\n-----------\n");
        
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("guest", "000"));
        list.add(new User("guest1", "000"));
        list.add(new User("guest", "000"));
        list.add(new User("guest2", "000"));
        list.add(new User("guest", "000"));
        
        List<User> toDelete = Arrays.asList(new User("guest",null));
        list.removeAll(toDelete);
        System.out.println(list);
                
    }
}
