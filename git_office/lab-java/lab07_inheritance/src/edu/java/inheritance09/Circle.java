package edu.java.inheritance09;

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }
    
    
}
