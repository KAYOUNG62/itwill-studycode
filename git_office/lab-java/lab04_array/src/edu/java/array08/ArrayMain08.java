package edu.java.array08;

import java.util.Random;

public class ArrayMain08 {

    public static void main(String[] args) {
        // Ch. 6-2 Ex 5. (p201)
        // 1 차원 정수 (int) 배열 3개를 갖는 2차원 배열을 선언
        Random random = new Random();
        int[][] array = new int[3][];

        // 첫번째배열에는 난수2개, 두번째 배열에는 난수 3개, 3번째 배열에는 난수 4개
        array[0] = new int[2];
        array[1] = new int[3];
        array[2] = new int[4];

        // 난수의 범위는 [70,100). >> 70이상 100미만.
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[i + 2];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(70, 100);
            }
        }

        // 배열의 내용을 확인
        for (int[] s : array) {
            for (int x : s) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        // 2차원 배열 array의 모든 원소들의 합(sum)-int 을 계산 하고 출력
        // 2차원 배열 array의 모든 원소들의 평균(avg)-double 을 계산하고 출력.

        
        int sum = 0; // 모든 원소들의 합계를 저장할 변수
        int count = 0; 
        double avg = 0.0;
        for (int[] arr : array) {
            for (int x : arr) {
                sum += x;
                count ++;
            }
        }

        avg = (double) sum / count;

        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);

    }

}
