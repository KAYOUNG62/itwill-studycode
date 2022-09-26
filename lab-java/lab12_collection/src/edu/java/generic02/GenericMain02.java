package edu.java.generic02;

public class GenericMain02 {

    public static void main(String[] args) {
        FruitBox appleBox = new FruitBox(); // 다형성
        appleBox.put(new Apple());
        // > put (Fruit fruit) 메서드를 호출할 때 전달하는 argument는 
        // Fruit 타입 객체 뿐만 아니라 Fruit를 상속하는 하위타입 객체 (예: Apple) 도 전달할 수 있음.
        // 상속 & 다형성 
        
        System.out.println(appleBox.get());
        // Fruit 타입을 리턴하는 메서드는 Fruit 타입의 객체 뿐만 아니라.
        // Fruit 을 상속하는 하위타입 객체(예: Apple)도 리턴할 수 있음.

        FruitBox orangeBox = new FruitBox();
        orangeBox.put(new Orange());
        System.out.println(orangeBox.get());

    }

}

abstract class Fruit {
}

class Apple extends Fruit {
    
}

class Orange extends Fruit {

}

class FruitBox {
    private Fruit fruit;

    public void put(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit get() {
        return fruit;
    }
}
