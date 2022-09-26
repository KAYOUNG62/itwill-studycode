package edu.java.modifier07;

public class StaticTest {
    int instanceVariable; // 인스턴스 변수
    static int staticVariable; // static 변수

    public void printVariables() {
        System.out.println("--- instance method ---");
        System.out.println("인스턴스 변수 = " + instanceVariable);
        System.out.println("static 변수 = " + staticVariable);
    }
    
    
    

    // 수식어들의 순서는 중요하지 않음. 리턴타입 앞에 순서 상관없이 붙을 수 있음. (static public void - )
    public static void printVariables2() {
        System.out.println("--- static method --- ");
//        System.out.println("인스턴스 변수 = " + instanceVariable); 
        // static 멤버는 static 이 아닌 멤버를 사용할 수 없다.
        System.out.println("static 변수 = " + staticVariable);
    }
}
