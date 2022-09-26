package edu.java.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMain03 {
    public static void main(String[] args) {
        // 정수들을 저장하는 리스트
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(numbers);

        // nembers 에서 짝수들만 선택해서 저장한 리스트

        List<Integer> evens = new ArrayList<>();
        for (Integer x : numbers) { // 리스트의 모든 원소를 차례로 반복하면서
            if (x % 2 == 0) { // 짝수들을 필터링
                evens.add(x); // 새로운 리스트에 추가
            }
        }
        System.out.println(evens);

//        for (int e = 0; e < numbers.size(); e++) {
//            if (numbers.get(e) % 2 == 0) {
//                evens.add(numbers.get(e));
//            }
//        }
//        System.out.println(evens);

        List<Integer> evens2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList()); // 람다표현식
        
        System.out.println(evens2);

        // numbers에서 홀수들만 선택해서 자장한 리스트
        List<Integer> odds = new ArrayList<>();
        for (int od = 0; od < numbers.size(); od++) {
            if (numbers.get(od) % 2 == 1) {
                odds.add(numbers.get(od));
            }
        }
        System.out.println(odds);
        
        List<Integer> odds2 = numbers.stream()
                .filter(y -> y % 2 == 1)
                .collect(Collectors.toList());
        System.out.println(odds2);
    
        //numbers에서 짝수들의 제곱을 저장하는 리스트 4.16.36
        List<Integer> result = new ArrayList<>();
        for (Integer s : numbers) {
            if (s % 2 ==0) {
                result.add(s * s);
            }
        }
//        for(int r = 0; r<numbers.size(); r++) {
//            if (numbers.get(r) % 2 == 0) {
//                result.add(numbers.get(r) * numbers.get(r));
//            }
//        }
        System.out.println(result);
    
        result = numbers.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList());
        System.out.println(result);
    
        
        List<String> langs = Arrays.asList("Java", "SQL" , "HTML" ,"JavaScript", "Python");
        
        //langs 에서 5글자 이상의 문자열들을 찾고, 모두 소문자로 변환한 리스트
        
        List<String> fivelangs = new ArrayList<>();
        for (String s : langs) {
            if (s.length() >= 5) {
               fivelangs.add(s.toLowerCase()); 
            }
        }
        System.out.println(fivelangs);
        
        List<String> fivelangs2 = new ArrayList<>();
        fivelangs2 = langs.stream()
                .filter(s -> s.length() >= 5)
                .map(s -> s.toLowerCase()) //map(String::toLowerCase)
                .collect(Collectors.toList());
        
        System.out.println(fivelangs2);
    }
}
