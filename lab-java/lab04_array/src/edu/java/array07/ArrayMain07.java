package edu.java.array07;

import java.util.Random;

public class ArrayMain07 {

    public static void main(String[] args) {
        // Chapter 6-2 Ex.4 200p
        // 정수 int 10개를 저장하는 배열(array) 선언
        // 배열의 0이상 10이하 정수 난수 10개를 저장. Random
        // 배열에서 최댓값을 찾으세요.
        // max = array[0] 가정
        // for (array의 모든 원소들) :
        // if (max < array 원소):
        // max = array 원소

        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(11);
        }
        for (int s : array) {
            System.out.print(s + " ");
        }
        int max = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
            }
        }
        //다른 방법
        for (int x : array) { // > 배열 array 에서 원소를 하나씩 꺼내면서
            // if 대체할 다른 방법 삼항연산자
            //max = (max < x) ? x : max;
            if (max < x) { // > 배열에서 꺼낸 원소x가 max 보다 크다면
                max = x; // 최개값을 더 큰 값으로 설정.
            }
        }
        
        
        System.out.println();
        System.out.println("max = " + max);

    }

}
