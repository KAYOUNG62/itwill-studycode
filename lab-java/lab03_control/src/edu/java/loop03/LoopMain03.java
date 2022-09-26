package edu.java.loop03;

public class LoopMain03 {

    public static void main(String[] args) {
        /*
         * 아래와 같은 형식으로 구구단 2단을 출력하세요. 2 x 1 =2 2 x 2 =4 2 x 3 =6 ... 2 x 9 = 18
         */

        for (int n = 1; n < 10; n++) {
//            System.out.println("2 x " + n + " = " + (n * 2));
            System.out.printf("2 x %d = %d\n", n, (n * 2));
            // System.out.printf > %_의 공간의 뒤에 있는 순서대로 들어감
            // %d : 정수 , %f : 실수 , %s : 문자열
            // \n : 줄바꿈 new line , \t : tab(탭)
            // System.out.printf() : 문자열을 포맷에 맞춰서 출력
        }
        System.out.println("-----");
        for (double i = 1.1; i < 10.0; i++) {
            System.out.printf("2 x %.2f = %.2f\n", i, (i * 2));
        }

        System.out.println("-----");
        for (int x = 1; x <= 100; x++) {
            System.out.print(x + "\t");
            if (x % 10 == 0) {
                System.out.println();
            }
        }
    }

}
