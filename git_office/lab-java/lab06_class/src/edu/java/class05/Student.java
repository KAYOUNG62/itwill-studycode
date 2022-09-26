package edu.java.class05;

public class Student {
    // field
    int stuNo; // 학번
    String stuName; // 학생 이름
    Score score; // 국어, 영어, 수학 점수

    // 기본생성자, \
    // argument : stuNo , stuName ( int , String, Score) ,
    // argument : int String, int, int, int (국영수)
    public Student() {
    }

    public Student(int stuNo, String stuName, Score score) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.score = score;
    }

    public Student(int stuNo, String stuName, int korean, int english, int math) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.score = new Score(korean, english, math);

        // this(stuNo, stuName, new Score(korean, english, math)); 로 변경가능.
    }

    // method 학생정보( 학번, 이름, 국영수 과목 점수, 총점, 평균) 를 출력하는 메서드
    public void printStuImfo() {
        System.out.println("---학생 정보---");
        System.out.println("학번: " + this.stuNo);
        System.out.println("이름: " + this.stuName);
        if (score != null) {
            this.score.printScore(); // 국영수 점수 출력.
            System.out.println("총점: " + this.score.total());
            System.out.println("평균: " + this.score.avg());
        } else {
            System.out.println("점수 : null");
        }

    }

}
