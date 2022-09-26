package edu.java.map03;

import java.util.Arrays;
import java.util.HashMap;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 개수 세기(word counting)
        String sentence = "하늘 바다 땅 하늘 땅 사람";

        // 문자열을 공백으로 구분해서 단어들로만 이루어진 배열을 만듦
        String[] words = sentence.split(" ");
        for(String w: words) {
            System.out.print(w + ", ");
        }
        System.out.println();
        
        // 단어(key) - 빈도수(value) 를 저장하기 위한 map을 선언, 생성
        HashMap<String, Integer> wordCounts = new HashMap<>();
        System.out.println(wordCounts);

        // 배열의 원소들을 하나씩 반복하면서
        for (String w : words) {
            Integer count = wordCounts.get(w);
            if (count == null) {
                // 단어가 map 의 key로 존재하지 않으면 "단어=1" 을 map에 저장
                wordCounts.put(w, 1);
            } else { 
                // 단어가 map 에 key로 존재하면, key에 해당하는 value(기존 등장 횟수) + 1 값을 맵에 저장
                wordCounts.put(w, count+1);
            }
        // 문자열 sentence에 등장하는 단어를 key로 하고
        // 그 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력.
        // 결과 : {땅 = 2, 바다 = 1, 사람 = 1, 하늘 = 2}
            System.out.println(wordCounts);
        }
        System.out.println("-----");
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words) {
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }
        System.out.println(map);    
        
            

    }

}
