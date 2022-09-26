package edu.java.inheritance09;

public class AbstractMain03 {

    public static void main(String[] args) {
        // Rectangle, Circle 클래스를 구현 (implement)
        // Rectangle, Circle 타입의 객체에서 draw() 메서드 동작 여부 학인

        Shape[] shapes= { new Circle(10) , new Rectangle("Rectangle" , 4, 3), new Square(5)};
        
        for (Shape s : shapes) {
            s.draw();
        }
        
        System.out.println();

        Shape rectangle = new Rectangle("Rectangle" , 5, 4);
        rectangle.draw();

        Shape circle = new Circle(5);
        circle.draw();

    }

}
