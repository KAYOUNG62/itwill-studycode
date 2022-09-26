package edu.java.class03;

public class ClassMain03 {

    public static void main(String[] args) {
        //Rectangle 타입의 변수 선언, Rectangle 객체 생성 저장.
        // Rectangle 객체의 메서드 테스트

        // 1) 기본 생성자
        Rectangle rectangle = new Rectangle();

        System.out.println("rect1 가로 = " + rectangle.width);
        System.out.println("rect1 세로 = " + rectangle.height);

        System.out.println(rectangle.perimeter());
        System.out.println(rectangle.area());

        // 2) argument2개를 갖는 생성자 이용.

        Rectangle rectangle2 = new Rectangle(3, 4);
        
        System.out.println("rect2 가로 = " + rectangle2.width);
        System.out.println("rect2 세로 = " + rectangle2.height);

        System.out.println(rectangle2.perimeter());
        System.out.println(rectangle2.area());

    }
}
