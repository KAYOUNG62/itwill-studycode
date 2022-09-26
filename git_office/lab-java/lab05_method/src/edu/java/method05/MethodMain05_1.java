package edu.java.method05;

public class MethodMain05_1 {

    public static void main(String[] args) {
        // 메서드 작성 연습
        int[] scores = { 70, 60, 100, 50, 80 };

        int sum = sum(scores);
        System.out.println("총점 = " + sum); // 360

        double avg = mean(scores);
        System.out.println("평균 = " + avg); // 72.0

        int max = max(scores);
        System.out.println("최댓값 = " + max); // 100

        int min = min(scores);
        System.out.println("최소값 = " + min); // 50
        
        System.out.println("분산 = " + variance(scores));
        System.out.println("표준편차 = " + standardDeviation(scores));

    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int x : array) {
            sum += x;
        }
        return sum;
    }

    public static double mean(int[] array) {
        // 평균 = 합계 / 원소개수
        int total = sum(array);
        double avg = (double) total / array.length;
        return avg;
    }

    public static int max(int[] scores) {
        int max = scores[0];
        for (int x : scores) {
            max = (max < x) ? x : max;
        }
        return max;

    }

    public static int min(int[] scores) {
        int min = scores[0];
        for (int s : scores) {
            min = (min > s) ? s : min;
        }
        return min;
    }

    public static double variance(int[] array) {
        // 분산 var = ((x1 - mu)^2(제곱) + (x2 - mu)^2 + ... + (xn -mu)^2)/n
        // 표준편차 std = sqrt(var)
        // 데이터 : {x1, x2, ... , xn}
        // 평균 : mu = (x1 + x2 + ... +xn )/n

        double mu = mean(array);
        double total = 0;
        for (int x : array) {
            total += (x - mu) * (x - mu);
        }
        double var = total / array.length;

        return var;
    }
    //표준편차
    public static double standardDeviation(int[] array) {
        return Math.sqrt(variance(array));
    }
}
