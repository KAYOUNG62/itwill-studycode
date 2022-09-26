package edu.java.loop05;

public class LoopMain05 {

    public static void main(String[] args) {
        // 369 게임

        for (int x = 1; x <= 100; x++) {
            System.out.print(x + "\t");
            if (x % 10 == 0) {
                System.out.println();
            }
        }

        System.out.println("-----------");

        for (int x = 1; x <= 100; x++) {
            int uni = x % 10;
            int ten = x / 10;

            if (uni == 3 || uni == 6 || uni == 9 || (ten == 3 || ten == 6 || ten == 9)) {
                System.out.print("*\t");
            } else {
                System.out.print(x + "\t");
            }

            if (x % 10 == 0) {
                System.out.println();
            }
        }
    }
}
