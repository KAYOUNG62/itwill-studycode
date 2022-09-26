package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMain03 {
    public static void main(String[] args) {
        // 문자열들을 원소로 갖는 리스트를 생성하고 초기화
        List<String> languages = Arrays.asList("Java", "SQL", "HTML", "CSS", "JavaScript", "JSP", "Spring", "Python",
                "Servlet");
        System.out.println(languages);

        // 리스트 languages에서 5글자 이상인 문자열들만 저장하는 리스트를 생성, 출력
        List<String> fiveLang = new ArrayList<>(); // 다형성
        for (String s : languages) {
            if (s.length() >= 5) {
                fiveLang.add(s);
            }
        }
        System.out.println(fiveLang);
        
        //Iterator<E> 사용
        List<String> longWords = new ArrayList<>();
        Iterator<String> itr = languages.iterator();
        while(itr.hasNext()) {
            String s = itr.next();
            if ( s.length() >=5) {
                longWords.add(s);
            }
        }
        System.out.println(longWords);

        

        // 리스트 languages에서 원소들의 글자수를 저장하는 리스트를 만들고 출력
        List<Integer> wordLength = new ArrayList<>();
        for (String s : languages) {
            wordLength.add(s.length());
        }
        System.out.println(wordLength);

        // 정수(1,2)들을 저장하는 리스트를 만들고 초기화.
        List<Integer> genderCodes = Arrays.asList(1, 1, 2, 2, 1, 2, 2);

        // 리스트 genderCodes의 원소가 1이면 "Male" 2 이면 Female"을 저장하는 리스트를 만들고 출력
        LinkedList<String> gender = new LinkedList<>();

        for (int g = 0; g < genderCodes.size(); g++) {
            Integer x = genderCodes.get(g);
            if (x == 1) {
                gender.add("Male");
            } else {
                gender.add("Female");
            }
        }

        // 다른 방법1
//        for (Integer code : genderCodes) {
//          String gender = "";
//            if (code == 1  ) {
//                gender.add("Male");
//            } else {
//                gender.add("Female");
//            }
//        }

        // 다른방법2
//        for (Integer code : genderCodes) {
//        gender.add((code == 1) ? "Male" : "Female");
//        }
        System.out.println(gender);
    }
}
