package edu.java.class01;

public class ClassMain01 {

    public static void main(String[] args) {
        // user 클래스 타입으로 변수 선언
        // . : 참조 연산자
        User user1 = new User();
        System.out.println(user1);
        System.out.println(user1.userId);
        System.out.println(user1.possword);
        System.out.println(user1.age);

        // Heap에 저장되어 있는 (userId password) 값이 저장되어있는 메모리의 주소를 . (참조연산자로) 불러와서 Stack에
        // 저장함.

        user1.userId = "admin";
        user1.possword = "1234";
        user1.age = 16;

        System.out.println(user1.userId);
        System.out.println(user1.possword);
        System.out.println(user1.age);

        User user2 = new User("guest", "guest", 0);
        System.out.println(user2.userId);
        System.out.println(user2.possword);
        System.out.println(user2.age);

        User user3 = new User("NoName");
        System.out.println(user3.userId);
        System.out.println(user3.possword);
        System.out.println(user3.age);
    }

}
