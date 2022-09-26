package edu.java.array03;

import java.util.Random;

public class ArrayMain03_1 {

    public static void main(String[] args) {
        // Random 객체를 선언, 생성. new
        // 정수 10개를 저장할 수 있는 배열 (scores) 선언
        // 배열 scores 에 0이상 10이하의 정수 난수 10개 저장.
        // 배열 scores에 저장된 모든 점수들의 합계를 계산하고 출력
        // 배열 scores에 저장된 모든 점수들의 평균을 소수점까지 계산해서 출력.

        Random random = new Random();
        int[] scores = new int[10];
        
        for (int i = 0; i < 10; i++) {
            scores[i] = random.nextInt(10) + 1;

            System.out.print(scores[i] + " ");
        }
        int sum = 0;
        for (int s = 0; s < scores.length; s++) {
            sum += scores[s];
        }
        System.out.println();
        System.out.println("합계 = " + sum);

        double average = (double) sum / scores.length;
        System.out.println("평균 = " + average);
    }

}
