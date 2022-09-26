package edu.java.inheritance02;

public class Person { // super class
    //field
    private String name;
    
    //생성자
    //기본생성자
    public Person() {
        System.out.println("Person() 기본 생성자 호출");
    }

    //argument 를 갖는 생성자
    public Person(String name) {
        this.name = name;
        System.out.println("Person(name) 생성자 호출");
    }
    
    // getter / setter
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
