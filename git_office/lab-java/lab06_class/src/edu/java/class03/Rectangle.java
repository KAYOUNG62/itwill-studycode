package edu.java.class03;

// class = field + constructor + method > data type

public class Rectangle {
    // field - 가로 세로
    // constructor - 기본생성자, argument 2개를 갖는 생성자
    // method - 둘레 길이, 넓이

    double width; // 직사각형의 가로
    double height; // 직사각형의 세로

    public Rectangle( ) {
        
    }
    
    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;

    }

    public double perimeter() {
        return 2 * (this.height + this.width); // this 생략 가능.
    }

    public double area() {
        return this.height * this.width; // this 생략 가능.
    }
}
