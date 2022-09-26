package edu.java.inheritance09;

//직사각형 (가로,세로)
public class Rectangle extends Shape {
    private double width;
    private double lenght;

    // 생성자
    public Rectangle(String type, double width, double lenght) {
        super(type); // super(type)로 작성 가능.
        this.width = width;
        this.lenght = lenght;
    }

    @Override
    public double area() {
        return width * lenght;
    }

    @Override
    public double perimeter() {
        return 2 * (this.width + this.lenght);
    }

}
