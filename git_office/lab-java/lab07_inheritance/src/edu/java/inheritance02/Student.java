package edu.java.inheritance02;

// 학생은 사람이다. > 사람 : super class, 학생: subclass
public class Student extends Person {
    // field
    private String school;

    public Student() {
        // super(); // 부모의 argument가 없는 기본 생성자를 호출, 생략가능.
        System.out.println("Student()기본 생성자 호출");
    }

    public Student(String school) { 
        // super(); 
        //superclass의 생성자를 명시적으로 호출하지 않은 경우에는 기본 생성자가 자동으로 호출.
        this.school = school;
        System.out.println("Student(school) 생성자 호출");
    }
    
    public Student(String name, String school) {
        super(name); // 부모클래스의 생성자에서 argument를 갖는 생성자를 호출할 경우 super(argument)
        this.school = school;
        System.out.println("Student(name, school) 생성자 호출");
    }
    
    //getter , setter 
    public String getschool() {
        return school;
    }
    
    public void setschool(String school) {
        this.school = school;
    }
}