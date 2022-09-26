package edu.java.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // for 반복문
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("-------");
        // while 반복문
        int n = 1;
        while (n <= 5) {
            System.out.println(n);
            n++;
        }
        System.out.println(n);

        // 10부터 1까지 정수들을 내림차순으로 한 줄에 출력하세요.
        int x = 10;
        while (x > 0) {
            System.out.print(x + " ");
            x--;
        }
        System.out.println();

        for (x = 10; x > 0; x--) {
            System.out.print(x + " ");
        }
        System.out.println();
        // 10 이하의 양의 홀수들을 한 줄에 출력하세요.

        int c = 1;
        while (c < 10) {
            System.out.print(c + " ");
            c += 2;
        }

        System.out.println();

        for (c = 1; c <= 10; c += 2) {
            System.out.print(c + " ");
        }

        System.out.println();

        n = 1;
        while (n < 10) {
            if (n % 2 == 1) {
                System.out.print(n + " ");
            }
            n++;
        }
    }
}
