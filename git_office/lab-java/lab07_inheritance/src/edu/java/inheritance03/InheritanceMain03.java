package edu.java.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car 타입의 객체 생성

        Car sonata = new Car(100, 20);
        sonata.drive();

        // HybridCar 타입의 객체 생성
        HybridCar x3 = new HybridCar(50, 60, 100);
        x3.drive(); // 하위 클래스에서 override된 메서드를 호출
        
        // 다형성(polymorphism): 하나의 객체를 두개 이상의 타입으로 부를 수 있는 것.
        Car k8 = new HybridCar(10, 10, 10); // < 다형성
        //HybridCar x = new Car(100, 100); 컴파일에러
        k8.drive();
        // 다형성을 적용하더라도 override 되어있는 drive() 메서드가 실행됨
        // 다형성은 코드의 재사용성(reuse)을 높여줌.
        // - 배열/ 리스트 사용. 메서드 파라미터 선언.
        // 배열을 선언할 때 상위(super) 타입의 배열로 선언하면, 상위타입은 물론 하위 타입의 객체까지도 저장할 수 있음.
        
        // 다형성이 적용된 예 : println()
        Car[] cars = {sonata, x3};
        System.out.println(new Car(5, 5));
    }
    
    public static void test(Car car) {
        
    }
    
}