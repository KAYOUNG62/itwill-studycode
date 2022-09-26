package edu.java.inheritance01;

//스마트TV는 TV이다. (Smart TV "IS A" TV.)
// BasicTv : super/parent/base class
// SmartTv : sub/child/derived class

public class SmartTv extends BasicTv { 
    //BasicTv 가 가지고 있는 private 변수는 볼 수 없지만 publicd 으로 선언된 getter/setter 는 사용 가능.
    //field (속성)
    private String ip;
    
    //getter/setter
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    
}
