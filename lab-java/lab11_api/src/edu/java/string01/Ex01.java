package edu.java.string01;

import java.util.Arrays;

public class Ex01 {

    public static void main(String[] args) {
        // String 클래스의 메서드들을 사용

        // ex-1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
        String ssn = "991231-1234567";
        System.out.println("주민등록번호 성별표시 숫자: " + ssn.charAt(7));

        // ex-2 아래의 문자열 배열에서 "홍길동" 의 문자열이 처음 등장하는 인덱스를 출력.
        // 만약에 "홍길동" 이 배열이 없는 경우에는 -1을 출력.
        String[] names = { "오쌤", "홍길동", "Jahe" };
        System.out.println("홍길동의 인덱스 " + Arrays.asList(names).indexOf("홍길동"));

        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("홍길동")) {
                index = i;
                break;
            }
        }
        System.out.println("홍길동의 인덱스 " + index);

        // ex-3 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력
        String[] languages = { "Java", "SQL", "JavaScript", "Python" };
        // TODO
        for (String i : languages ) {
            if (i.length() >=5) {
                System.out.print(i + "  ");
            }
        }
        System.out.println();
        // ex-4 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        String[] tests = { "TEST", "test", "TeSt", "tEsT", "테스트" };
//        System.out.println("TeSt".toLowerCase()); > 소문자로 변경해주는 메서드
//        System.out.println("TeSt".toUpperCase()); > 대문자로 변경해주는 메서드
        for (String s : tests) {
            if(s.toLowerCase().contains("est")) {
                System.out.print(s +"  ");
            }
        }
        System.out.println();

        // ex-5 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 년/월/일 정보를
        // int 타입 변수에 저장하고 출력.
        String date = "2022-09-07";
        String[] array = date.split("-"); // > { "2022","09","07" }
        System.out.println(array[0] + " , " + array[1]);
        int year = Integer.parseInt(array[0]);
        int month = Integer.parseInt(array[1]);
        int day = Integer.parseInt(array[2]);
        System.out.println(year +"," + month +","+ day);
    }

}
