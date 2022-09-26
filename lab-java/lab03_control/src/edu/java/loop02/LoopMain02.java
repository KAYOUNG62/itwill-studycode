package edu.java.loop02;

public class LoopMain02 {

    public static void main(String[] args) {
        // 복합 할당 연산자 : += , -=, *=, /=, %=...)
        int x = 1;

        // x = x + 3;
        x += 3; // x + 3이랑 같은 값
        System.out.println("x = " + x);

        // 0 2 4 6 8 10을 한줄씩 출력
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }

        for (int n = 0; n <= 5; n++) {
            System.out.println(n * 2);
        }

        for (int n = 0; n <= 10; n++) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }
    }
}
