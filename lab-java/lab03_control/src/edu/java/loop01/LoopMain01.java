package edu.java.loop01;

public class LoopMain01 {

    public static void main(String[] args) {
        // 반복문
        System.out.println("Java" + 0);
        System.out.println("Java" + 1);
        System.out.println("Java" + 2);
        System.out.println("Java" + 3);
        System.out.println("Java" + 4);
        
        
        // for 문
        for (int i = 0; i <= 4; i++) {
            System.out.println("Java" + i);
        }

        // 증가연산자 : ++ , 감소연산자 : --

        // 10부터 1까지 내림차순
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }
}