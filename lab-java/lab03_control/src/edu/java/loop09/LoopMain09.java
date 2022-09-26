package edu.java.loop09;

public class LoopMain09 {

    public static void main(String[] args) {
        // 1부터 100까지 자연수들의 합

//        int sum = 0;
//        for (int n = 1; n <= 100; n++) {
//            sum += n;
//            System.out.println("sum = " + sum);
//        }

        // 2번문제 100이하 자연수 중의 3의 배수들의 합
        int sum = 0;
        for (int n = 3; n <= 100; n += 3) {
            sum += n;
        }
        sum = 0;
        for (int n = 1; n <= 100; n++) {
            if (n % 3 == 0) {
                sum += n;
            }
        }
        System.out.println(sum);

        sum = 0;
        int n = 1;
        while (n <= 100) {
            if (n % 3 == 0) {
                sum += n;
            }
            n++;
        }
    }

}
