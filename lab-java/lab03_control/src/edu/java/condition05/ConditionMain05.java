package edu.java.condition05;

import java.util.Random;

public class ConditionMain05 {

    public static void main(String[] args) {
        // Random 타입 변수를 선언하고, 초기화
        Random random = new Random();

        // Java 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int java = random.nextInt(101);
        System.out.println("Java = " + java);

        // SQL 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int sql = random.nextInt(101);
        System.out.println("SQL = " + sql);

        // JSP 과목의 점수를 0 이상 100 이하의 난수를 만들어서 저장.
        int jsp = random.nextInt(101);
        System.out.println("JSP = " + jsp);

        // 세 과목의 평균을 계산.
        double average = (java + sql + jsp) / 3.0;
        System.out.println("평균 = " + average);

        // 모든 과목의 점수가 40점 이상이고, 평균이 60점 이상이면 "합격",
        // 그렇지 않으면 "불합격" 출력
        String pass = (java >= 40 && sql >= 40 && jsp >= 40 && average >= 60) ? "합격" : "불합격";
        System.out.println(pass);

        if (java >= 40 && sql >= 40 && jsp >= 40 && average >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }

        if (java < 40 || sql < 40 || jsp < 40 || average < 60) {
            System.out.println("불합격");
        } else {
            System.out.println("합격");
        }

        if (java < 40 || sql < 40 || jsp < 40) {
            System.out.println("불합격");
        } else if (average > +60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
        
    }

}
