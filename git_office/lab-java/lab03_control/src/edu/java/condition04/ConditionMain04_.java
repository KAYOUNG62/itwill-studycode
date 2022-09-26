package edu.java.condition04;

import java.util.Random;

public class ConditionMain04_ {

    public static void main(String[] args) {
        // 0이상 10이하(11미만)의 정수 난수를 생성해서 변수(z)에 저장.
        // 문자열 변수를 선언, 변수 z가 짝수이면 "even", 홀수이면 "odd" 를 저장.
        // 문자열(even/odd)을 출력.
        Random random = new Random();

        int z = random.nextInt(11);
        System.out.println("z = " + z);

        String str = (z % 2 == 0) ? ("even") : ("odd");
        System.out.println("str = " + str);
    }

}
