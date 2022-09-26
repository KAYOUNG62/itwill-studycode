package edu.java.class04;

public class Circle {
    // field(멤버변수, property) - 반지름
    // constructor -기본생성자, argument를 갖는 생성자
    // method - 둘레 길이 (2*3.14*r), 넓이 (3.14*r*r)

    double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double perimeter() {
        return 2 * 3.14 * radius; // 2 * Math.PI * this radius 대체 가능
    }

    public double area() {
        return 3.14 * radius * radius; // Math.PI * this radius * this radius 대체 가능
    }

}
