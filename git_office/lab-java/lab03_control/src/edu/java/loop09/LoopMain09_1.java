package edu.java.loop09;

public class LoopMain09_1 {

    public static void main(String[] args) {
        //1부터 100까지 자연수들의 합 
        
        // 2번
        System.out.println("-----2번-----");
        int sum = 0;

        for (int x = 1; x < 100; x++) {
            if (x % 3 == 0) {
                sum += x;
            }
        }
        System.out.println(sum);

        // 3번
        System.out.println("-----3번-----");

        while (true) {
            int n1 = (int) (Math.random() * 6) + 1;
            int n2 = (int) (Math.random() * 6) + 1;
            System.out.println("(" + n1 + "," + n2 + ")");
            if (n1 + n2 == 5) {
                break;
            }
        }
        
        // 4번
        System.out.println("-----4번-----");
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                if (4 * x + 5 * y == 60) {
                    System.out.println("(" + x + "," + y + ")");
                }
            }
        }

        // 5번
        System.out.println("-----5번-----");
        for (int i = 1; i < 5; i++) {
            for (int s = 1; s < i + 1; s++) {
                System.out.print("*");
            }
            System.out.println();
        }


        // 6번
        System.out.println("-----6번-----");
        for (int i = 0; i < 4; i++) {
            for (int s = 3; s > i; s--) {
                System.out.print(" ");
            }
            for (int s = 0; s < i + 1; s++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 7번
        System.out.println("-----7번-----");
        
    }
}
