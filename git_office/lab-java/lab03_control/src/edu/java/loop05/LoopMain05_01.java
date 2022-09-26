package edu.java.loop05;

public class LoopMain05_01 {

    public static void main(String[] args) {
        // 369 게임 (확장편, 3, 6, 9 가 두번 들어가면 **로 변경 )

        for (int i = 1; i < 101; i++) {
            int n1 = i % 10;
            int n10 = i / 10;

            boolean b1 = (n1 == 3) || (n1 == 6) || (n1 == 9); // 1의 자리수가 3,6,9 이면
            boolean b10 = (n10 == 3) || (n10 == 6) || (n10 == 9); // 10의 자리수가 3,6,9 이면

            if (b1 && b10) {
                // 만약의 1의 자리수가 3, 6, 9 이고, 10의 자리수가 3, 6, 9 이면
                System.out.print("**\t");
            } else if (b1 || b10) {
                // n1 == 3|| n1 == 6 || n1 == 9 || n10 ==3 || n10 == 6 || n10 == 9 을 boolean 을
                // 넣어서 간략하게 만들수 있다.
                System.out.print("*\t");
            } else {
                System.out.print(i + "\t");
            }
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}