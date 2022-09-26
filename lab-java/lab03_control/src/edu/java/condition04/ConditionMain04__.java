package edu.java.condition04;

import java.util.Random;

public class ConditionMain04__ {

    public static void main(String[] args) {
        // 0이상 10이하(11미만)의 정수 난수 2개를 저장.
        // int 타입 변수 bigger에 두 난수 중에서 크거나 같은 숫자를 저장.
        // bigger를 출력

        Random random = new Random();

        int x = random.nextInt(11);
        System.out.println("x = " + x);
        int y = random.nextInt(11);
        System.out.println("y = " + y);

        int bigger = (x >= y) ? x : y;
        System.out.println("bigger = " + bigger);

    }

}
