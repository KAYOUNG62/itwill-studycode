package edu.java.exception06;

public class ExceptionMain06 {

    public static void main(String[] args) {
        
        Calculator calc = new Calculator();
        
        try {
            int result = calc.divide(1, 0);
            System.out.println(result);
            // > 반드시 예외 처리를 해야하는 exception 을 throws 한다고 선언된 메서드를 
            // 호출할때는 try-catch 구문을 사용하더나 throws 선언문을 메서드에 추가해야 함.
        } catch (Exception e) {
            e.printStackTrace();
            // ㄴ 예외가 발생한 이유와 예외가 발생되기 까지의 코드 호출 순서를 출력해줌
        }
        System.out.println("정상종료");
        
        
//        try {
//        int result = calc.divide(100, 0);
//        System.out.println(result);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }

}
