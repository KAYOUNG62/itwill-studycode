package edu.java.loop08;

public class LoopMain08 {

    public static void main(String[] args) {
        // 중첩 반복문
//        for (int dan = 2; dan < 10; dan++) {
//            for (int n = 1; n < 10; n++) {
//                System.out.println(dan + " x " + n + " = " + (dan * n));
//            }
//            System.out.println("-----------");

        for (int dan = 2; dan < 10; dan++) {
            System.out.println("---" + dan + "단 ---");

            for (int n = 1; n < 10; n++) {
                System.out.println(dan + " x " + n + " = " + (dan * n));
            }
        }

        System.out.println();

//        int d = 2;
//        while (d < 10) {
//            System.out.println("--- " + d + "단 ---" );
//            
//            int s = 1;
//            while(s < 10 ) {
//                System.out.println(d + " x " + s + " = " + (d * s));
//                s++;
//            }
//            d++;
//        }

        System.out.println();

        // 2단은 2x2까지 3단은 3x3까지 ..9단은 9x9까지

        int d = 2;
        while (d < 10) {
            System.out.println("--- " + d + "단 ---");

            int s = 1;
            while (s <= d) {
                System.out.println(d + " x " + s + " = " + (d * s));
                s++;
            }
            d++;
        }

        for (int k = 2; k < 10; k++) {
            System.out.println("---" + k + "단---");

            for (int v = 1; v <= k; v++) {
                System.out.println(k + " x " + v + " = " + (k * v));
            }
        }

        for (int i = 2; i < 10; i++) {
            System.out.println("--- " + i + "단 ---");

            for (int s = 1; s <= 10; s++) {
                System.out.println(i + " x " + s + " = " + (i * s));
                if (i == s) {
                    break; // 안쪽 for 문을 종료
                }
            }
        }
        System.out.println();

        for (int i = 2; i < 10; i++) {
            System.out.println("--- " + i + "단 ---");
            for (int j = 1; j <= i; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }

        int x = 2;
        while (x < 10) {
            System.out.println("--- " + x + "단 ---");

            int y = 1;
            while (y < 10) {
                System.out.println(x + " x " + y + " = " + (x * y));
                
                if (x == y) {
                    break;
                }
                y++;
            }
            x++;
        }
        
        //
        x =2;
        while (x < 10) {
            System.out.println("--- " + x + "단 ---");
            
            int y =1;
            while (y <=x) {
                System.out.println(x + " x " + y + " = " + (x * y));
                y++;
            }
            x++;
        }
    }
}