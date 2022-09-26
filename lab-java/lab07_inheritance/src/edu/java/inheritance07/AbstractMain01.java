package edu.java.inheritance07;

// 추상메서드(abstract method)
//  메서드의 signature(수식어, 리턴타입, 파라미터)만 선언되어있고, 본체({...}가 정의되지 않은 메서드.
//  추상 메서드는 반드시 abstract 수식어를 사용해야함.
//  추상 메서드의 선언은 반드시 세미콜론(;)으로 끝나야함.
//  본체가 없기 때문에 호출이 불가능하다. 

// 추상 클래스( abstract class)
//  abstract 수식어가 사용된 클래스
//  대부분의 경우, 추상 클래스는 1개 이상의 추상 메서드를 가지고 있음. 
//  추상 메서드를 가지고 있는 경우에는 클래스 선언에서 abstract를 반드시 사용해야함.
//  추상 클래스는 객체를 생성할 수 없음.

// 추상 메서드와 추상 클래스는 상속하는 하위 클래스에서 구현을 목적으로 함.

abstract class Animal {
    public abstract void move();
}

class Dog extends Animal {
    @Override // 추상 메서드를 재정의해서 메서드 본체를 작성. > 구현(implement)
    public void move() {
        System.out.println("강아지가 총총");
    }
}

class Fish extends Animal {

    @Override
    public void move() {
        System.out.println("물고기 팔딱");
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("새는 훨훨 ");
    }
}


public class AbstractMain01 {

    public static void main(String[] args) {
        Animal dog = new Dog(); // 다형성 
        dog.move();
        
        Fish fish = new Fish();
        fish.move();
        
        Animal bird = new Bird() ;
        bird.move();
        
        
        System.out.println();
        Animal[] animals = {dog, fish, bird};
        for (Animal a : animals) {
            a.move();
        }
            


    }

}
