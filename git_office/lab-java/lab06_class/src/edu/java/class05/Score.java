package edu.java.class05;

public class Score {
    // field
    int korean;
    int english;
    int math;

    // constructor -기본 생성자, argument를 갖는 생성자.

    public Score() {

    }

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    // 세 과목의 점수를 출력하는 메서드.
    // 세 과목의 총점을 리턴하는 메서드.
    // 세 과목의 평균(소수점까지 계산)을 리턴하는 메서드

    public void printScore() {
        System.out.println("국어 점수: " + this.korean);
        System.out.println("영어 점수: " + this.english);
        System.out.println("수학 점수: " + this.math);
    }

    public int total() {
        int total = korean + english + math;
        return total;
    }

    public double avg() {
        return (double) total() / 3;
    }
}
