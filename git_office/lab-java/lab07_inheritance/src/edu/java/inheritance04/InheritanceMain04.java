package edu.java.inheritance04;

public class InheritanceMain04 {

    public static void main(String[] agrs) {
        // 다형성과 타입 강제 변환(casting) & instanceof 연산자
        Parent ch1 = new Child(); // 다형성
        ch1.testParent();
        // ch1 변수는 Parent로 선언되어 있기 때문에 Parent의 메서드만 보임.
        // ch1은 실제로 Child 타입의 변수이기 때문에 Child의 메서드도 사용할 수 있어야함.
        ((Child) ch1).testChild();

        Parent ch2 = new AnotherChild();
//        ((Child) ch2).testChild();
        // AnotherChild 와 Child 클래스는 서로 casting 될 수 없는 클래스이기 때문에
        // 문법적으로는 가능하나 실행할 때 에러가 발생함.
        // 변수 instanceof 클래스이름:
        // 변수가 클래스타입의 인스턴스이면 true, 그렇지 않으면 false.
        if (ch2 instanceof Child) {
            ((Child) ch2).testChild();
        } else if (ch2 instanceof AnotherChild) {
            ((AnotherChild) ch2).testAnoterChild();
        } else {
            ch2.testParent();
        }
        // 순서주의 instanceof 검사를 할 경우 sub 타입을 먼저 작성 후 super 타입을 나중에 작성해야된다.

        // final 메서드 : override 할 수 없는 메서드.
        // final 클래스 : 상속받을 수 없는 클래스.
    }

}

class Parent {
    public void testParent() {
        System.out.println("I'm your father");

    }
}

class Child extends Parent {
    public void testChild() {
        System.out.println("child...");
    }
}

class AnotherChild extends Parent {
    public void testAnoterChild() {
        System.out.println("...");
    }
}