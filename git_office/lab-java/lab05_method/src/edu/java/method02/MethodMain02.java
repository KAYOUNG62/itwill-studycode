package edu.java.method02;

public class MethodMain02 {

    public static void main(String[] args) {
        // 리턴 타입과 argument를 갖는 메서드 작성/호출 연습.
        // add() 메서드 호출
        double result = add(1, 2);
        System.out.println(result);

        // subtract() 메서드 호출
        double sub = subtract(3, 1);
        System.out.println(sub);

        result = maltiply(3, 2);
        System.out.println(result);
        System.out.println(maltiply(1, 2));
        
        result = divide(6, 2);
        System.out.println(result);
        System.out.println(divide(4, 2));
    }

    /**
     * 숫자 두개를 전달받아서, 두 숫자의 덜셈 결과를 변환.
     * 
     * @param x double
     * @param y douvle
     * @return x + y
     */
    public static double add(double x, double y) {
        // return : 1. 메서드를 호출한 곳에 값을 반환. 2. 메서드 종료.
        return x + y;
    }

    /**
     * 숫자 2개를 전달받아서, 뺄셈의 결과를 반환
     * 
     * @param x double
     * @param y double
     * @return x - y
     */
    public static double subtract(double x, double y) {
        return x - y;
    }

    /**
     * 숫자 2개를 전달받아서, 곱셈의 결과를 반환
     * 
     * @param x double.
     * @param y double.
     * @return x * y
     */
    public static double maltiply(double x, double y) {
        return x * y;
    }

    /**
     * 숫자 2개를 전달받아서, 나눗셈의 결과를 반환
     * 
     * @param x double.
     * @param y double.
     * @return x / y
     */
    public static double divide(double x, double y) {
        return x / y;

    }

}
