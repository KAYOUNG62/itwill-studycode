package edu.java.lambda01;

public class LambdaMain01 {

    public static void main(String[] args) {
        // 인터페이스를 사용- 인터페이스를 구현하는 클래스
        // 1. 인터페이스를 구현하는 클래스를 별도의 java 파일에서 정의

        Calculable adder = new Adder(); // 다형성

        double result = adder.calculate(1, 2);
        System.out.println(result);

        // 2. 지역 클래스(local class)
        class Subtracter implements Calculable {

            @Override
            public double calculate(double x, double y) {
                return x - y;
            }
        }

//        Calculable subtracter = (x,y) -> x-y;

        Calculable subtracter = new Subtracter();
        double result2 = subtracter.calculate(3, 1);
        System.out.println(result2);

        // 3. 익명클래스(anonymous class)
        Calculable multiplier = new Calculable() {
            @Override
            public double calculate(double x, double y) {
                return x * y;
            }
        };
//        Calculable multiplier = (x , y) -> {return x * y;}; // (double x, double y) double 생략해도됨
        double result3 = multiplier.calculate(2, 2);
        System.out.println(result3);

        // 4. 람다 표현식(Lambda expression)
        Calculable divider = (x, y) -> x / y; // 실행 문장이 하나만 있는 경우 {}생략해도됨
        double result4 = divider.calculate(1, 2);
        System.out.println(result4);

//         람다 표현식(Lambda expression - 함수 표기법) 클래스 정의와 객체 생성을 동시에 하는 익명 클래스를 간단히 작성하기 위한
//         문법. 함수형 인터페이스(functional interface)만 람다 표현식으로 작성할 수 있음. 
//         함수형 인터페이스: 추상 메서드를 오직 한 개만 갖는 인터페이스. 
//         (param, ...) ->{...} 
//         람다 표현식의 파라미터 선언에서는 타입을 생략해도 됨. 람다 표현식의 body{...} 에서 실행 문장이 하나만 있는 경우 {}생략해도됨 
//         람다 표현식에서 body가 return 문장만 있는 경우에는 {}와 return까지 생략, 리턴값만 작성하면됨 
//         (parm, ...) -> 리턴값 
//         람다 표현식에서 파라미터 개수가 1개인 경우 () 생략 가능.

        
        // 익명클래스
        Printable printer1 = new Printable() {
            @Override
            public void print(String msg) {
                System.out.println(msg.toLowerCase());
            }
        };
        printer1.print("Hello");

        Printable printer2 = msg -> System.out.println(msg.toUpperCase());
        printer2.print("Hello");

        // 메서드 참조(method reference) 1
        // 람다표현식에서 파라미터가 1개이고, 메서드 바디의 실행 문장도 1개뿐인데,
        // 람파표현식의 파라미터가 실행문장의 argument로 그대로 전달되는 경우에 사용
        // Printable printer3 = msg ->System.out.println(msg);
        Printable printer3 = System.out::println;
        printer3.print("Hello");

        // 메서드 참조(method reference) 2
        // 람다 표현식에서 파라미터가 1개이고, 메서드바디에 실행문장도 1개인 경우,
        // 그 실행문장이 파라미터의 메서드를 호출하는 경우.
        // Mapper mapper = (s) ->{return s.length();};
        // Mapper mapper = s -> s.length();
        Mapper mapper = String::length;
        System.out.println(mapper.map("olleh"));

    } // main()
} // class
