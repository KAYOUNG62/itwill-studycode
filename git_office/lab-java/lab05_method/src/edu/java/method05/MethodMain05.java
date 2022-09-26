package edu.java.method05;

public class MethodMain05 {

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
    }

    public static int sum(int[] scores) {
        int sum = 0;
        for (int s = 0; s < scores.length; s++) {
            sum += scores[s];
        }
        return sum;
    }

    public static double mean(int[] scores) {
        double mean = (double) sum(scores) / scores.length;
        return mean;
    }

    public static int max(int[] scores) {
        int max = scores[0];
        for (int m : scores) {
            if (max < m) {
                max = m;
            }
        }
        return max;
    }

    public static int min(int[] scores) {
        int min = scores[0];
        for (int n : scores) {
            if (min > n) {
                min = n;
            }
        }
        return min;
    }
}
