package edu.java.set03;

import java.util.HashSet;
import java.util.Random;

public class SetMain03 {

    public static void main(String[] args) {
        // HashSet<E> 사용.
        // [0, 10) 범위의 정수 난수 5개를 저장. (동일한 숫자를 저장할 수 없음)
        // Set의 내용을 출력
        Random random = new Random();

        HashSet<Integer> set = new HashSet<>();

//        while (set.size() < 5) {
//            set.add(random.nextInt(10));
//        }
//        System.out.println(set);

        while (true) {
            int r = random.nextInt(10); // 난수 만듦
            System.out.println("r = " + r);

            set.add(r); // 난수를 set에 저장
            System.out.println("set = " + set);
//            set.add(random.nextInt(10));
//            System.out.println(set);

            if (set.size() == 5) { // set 의 원소개수가 5개이면
                break; // 반복문 종료
            }
        }
    }

}
