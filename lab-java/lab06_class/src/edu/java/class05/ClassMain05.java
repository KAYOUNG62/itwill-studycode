package edu.java.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // Score 타입의 객체 생성, 메서드들을 테스트.

        Score score1 = new Score();
        score1.printScore(); // 리턴값이 없는 void이기 때문에 다른 문자열과 같이 쓸 수 없음.
        System.out.println("총점: " + score1.total()); // 리턴해주는 값이 있으면 다른 문자열과 같이 쓸 수 있음.
        System.out.println("평균: " + score1.avg());

        System.out.println("--------------");

        Score score2 = new Score(80, 90, 70);
        score2.printScore();
        System.out.println("총점: " + score2.total());
        System.out.println("평균: " + score2.avg());

        System.out.println();
        // Student 타입의 객체 생성, 메서드를 테스트.

        Student stu1 = new Student();
        stu1.score = score1; // nullpoint 오류 해결위해 위의 값을 불러올수있음. 혹은 메소드에 if 값을 넣어서 오류안뜨게 할 수 있음.
        stu1.printStuImfo();

        System.out.println("--------------");

        Student stu2 = new Student(1, "홍", score2);
        stu2.printStuImfo();

        System.out.println();

        Student stu3 = new Student(2, "허균", null);
        stu3.printStuImfo();

        System.out.println();

        Student stu4 = new Student(3, "오쌤", new Score());
        stu4.printStuImfo();

        Student stu5 = new Student(4, "철수", 50, 90, 70);
        stu5.printStuImfo();

    }

}
