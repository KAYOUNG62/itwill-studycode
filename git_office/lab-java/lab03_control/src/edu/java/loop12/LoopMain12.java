package edu.java.loop12;

public class LoopMain12 {

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= 4; i++) {
            int space = 4 - i;// i번째 라인에서 출력할 공백의 갯수
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= 4; i++) { // 라인수가 1~4까지
            for (int j = 4; j >= 1; j--) { // 각 줄에서 자릿수 4~1까지
                if (j > i) { // 출력할 자릿수가 라인 숫자보다 크면
                    System.out.print(" "); // 공백
                } else {// 출력 위치가 라인 숫자봐 작거나 같으면
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
