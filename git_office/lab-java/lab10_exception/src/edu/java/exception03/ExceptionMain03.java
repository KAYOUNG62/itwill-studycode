package edu.java.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ExceptionMain03 app = new ExceptionMain03();

        int x = app.inputInteger();
        System.out.println("x = " + x);
    }

    private int inputInteger() {
        // Scanner를 사용해서 입력받은 정수를 리턴.
        // Integer.parseInt() , scanner.nextLine()사용
        // NumberFormatException을 처리
        int number = 0;
        while (true) {
            try {
                System.out.print("정수입력 =  ");
                number = Integer.parseInt(sc.nextLine());
                break; // 반복문 종료
            } catch (NumberFormatException n) {
                System.out.println("정수를 입력하세요");
                System.out.println(n.getMessage());
            }
        }
        return number;
    }

}
