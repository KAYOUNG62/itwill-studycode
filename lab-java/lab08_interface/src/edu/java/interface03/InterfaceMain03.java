package edu.java.interface03;

// 자바는 다중 상속을 지원하지않음. 단일 상속만 지원함.

class A{}
class B{}
class C extends A {} //단일상속
//class C extends A,B {} // 다중상속 > 자바는 지원하지 않음.

// 자바의 클래스가 구현하는 인터페이스의 개수는 제한이 없음.
interface E {}
interface F {}
class G implements E,F {} // 2개 이상의 인터페이스를 구현하는 클래스 선언.

// 인터페이스는 다른 인터페이스를 상속(extends) 할 수 있음.
// (주의)인터페이스는 2개 이상의 인터페이스를 상속(다중 상속)할 수 있음. 
interface H extends E,F {}

// (주의)인터페이스를 클래스를 상속할 수 없음!
//interface I extends A{} / 컴파일 에러

interface Buyer {
    void buy();
    
    default void register() {
        System.out.println("구매자 등록");
    }
}

interface Seller {
    void sell();
    
    default void register() {
        System.out.println("판매자등록");
    }
}

class User implements Buyer, Seller {

    @Override
    public void sell() {
        System.out.println("판매");
    }

    @Override
    public void buy() {
        System.out.println("구매");
    }
    // 2개의 인터페이스에 같은 signature를 같는 메서드가 있다면 반드시 재정의(override).
    @Override
    public void register () { // public 을 생략하면안됨
        Buyer.super.register(); // 두개의 super를 작성할 경우 앞에 이름을 붙혀줘야됨
        Seller.super.register();
    
    }
    
}

public class InterfaceMain03 {

    public static void main(String[] args) {
        // User 타입의 객체를 생성
        User user = new User();
        user.buy();
        user.sell();
        
        System.out.println();
        //다형성(polymorphism)
        Buyer user2 = new User();
        user2.buy(); 
        // user2 는 Buyer 라고 선언했기 때문에 Buyer의 메서드는 보이지만 Seller의 메서드는 보이지않음.
        // 하지만 실제 생성된 객체는 User 파입이기 때문에 casting(타입변환)을 하면 buy() sell() 모두 사용 가능.
        if (user2 instanceof User) { // 캐스팅방법
            ((User) user2).sell();
        }
        
        user2.register();

    }

}
