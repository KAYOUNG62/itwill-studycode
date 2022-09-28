package edu.java.swing10;

//MVC 모델 클래스 - 데이터를 정의하는 클래스 VO(Value Object)
public class Score {
    private int korean;
    private int english;
    private int math;

    public Score() {

    }

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public int getKorean() {
        return korean;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }

    // 총점 리턴하는 메서드
    public int sum() {
        return korean + english + math;
    }
    
    // 평균 리턴하는 메서드
    public double average() {
        return (double) sum() / 3; 
    }

    @Override
    public String toString() {
        return String.format("Score(korean=%d, english=%d, math=%d, sum=%d, avg=%.2f)", korean, english, math, sum(), average()); // %.2f > 소수점 두자리까지만 표시. 
    }

}
