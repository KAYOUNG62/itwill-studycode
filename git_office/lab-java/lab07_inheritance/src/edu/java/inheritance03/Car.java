package edu.java.inheritance03;

public class Car {
    //field
    private double fuel; // 연료
    private double speed;
    
    //constructor
    public Car(double fuel, double speed) {
        this.fuel = fuel;
        this.speed = speed;
    }
    
    public void drive() {
        System.out.println("speed: " + speed + " fuel: " + fuel);
    }

    public double getFuel() {
        return fuel;
        
    }
    public double getspeed() {
        return speed;
        
    }
}
