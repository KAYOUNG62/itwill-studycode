package edu.java.class04;

public class ClassMain04 {

    public static void main(String[] args) {

        Circle circle = new Circle();

        System.out.println(circle);
        System.out.println("cricle 반지름= " + circle.radius);
        System.out.println("cricle 둘레 길이= " + circle.perimeter());
        System.out.println("cricle 둘레 넓이= " + circle.area());

        System.out.println();

        Circle circle2 = new Circle(10);

        System.out.println(circle2);
        System.out.println("cricle2 반지름= " + circle2.radius);
        System.out.println("cricle2 둘레 길이= " + circle2.perimeter());
        System.out.println("cricle2 둘레 넓이= " + circle2.area());

        Circle c3 = new Circle(10);
        System.out.println(c3);

 
        // 생성자를 호출할때마다 메모리의 다른 주소에 다른 객체가 만들어짐.
    }

}
