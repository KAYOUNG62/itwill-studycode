package edu.java.inheritance01;

//상속(inheritance)
//super class (상위클래스) , parent class(부모클래스), base class(기본클래스)
//sub class(하위클래스), child class(자식클래스), derived class(유도클래스)
//class SubClass extends SuperClass {...}

public class InheritanceMain01 {

    public static void main(String[] args) {
        // BasicTv타입의 객체 생성
        BasicTv tv1 = new BasicTv();
        tv1.powerOnOff(); // TV ON
        tv1.powerOnOff(); // TV OFF

        System.out.println();

        // SmartTv 타입의 객체 생성.
        SmartTv tv2 = new SmartTv();
        tv2.powerOnOff();
        tv2.powerOnOff();

        tv2.setIp("127.0.0.1");
        System.out.println(tv2.getIp());
    }
}
