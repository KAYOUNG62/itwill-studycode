package edu.java.list02;

import java.util.LinkedList;
import java.util.Random;

public class ListMain02 {

    public static void main(String[] args) {
        // 챕터 13장
        // 1. 정수를 저장하는 LinkedList 변수(numbers) 선언, 객체 생성.
        // 2. 리스트에 [0, 100) (0이상 100미만)범위의 정수 난수 20개를 저장.
        // 3. 난수가 저장된 리스트(numbers)를 출력.
        Random random = new Random();
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int a = 0; a < 21; a++) {
            numbers.add(random.nextInt(0, 100));
        }
        System.out.println(numbers);

        // 4. 홀수들만 저장하는 LinkedList 변수(odds) 선언, 객체 생성.
        // 5. 난수들이 저장된 리스트 numbers에서 홀수들만 odds저장.
        // 6. 리스트 odds를 출력.
        LinkedList<Integer> odds = new LinkedList<>();
        for (int d = 0; d < numbers.size(); d++) {
            if (numbers.get(d) % 2 == 1) {
                odds.add(numbers.get(d));
            }
        }
        System.out.println(odds);

        // 7. 짝수 제곱들을 저장하는 LinkedList 변수(evenSquares) 선언
        // 8. 난수들이 저장된 리스트 numbers에서 짝수들을 찾아서 그 제곱을 evenSquares에 저장
        // 9. 리스트 evenSquares를 출력
        LinkedList<Integer> evenSquares = new LinkedList<>();
        for (int e = 0; e < numbers.size(); e++) {
            if (numbers.get(e) % 2 == 0) {
                evenSquares.add((int) Math.pow(numbers.get(e), 2));
            }
        }

        System.out.println(evenSquares);

    }

}
