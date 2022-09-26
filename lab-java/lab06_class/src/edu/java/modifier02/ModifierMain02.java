package edu.java.modifier02;

import edu.java.modifier01.AccessTest;

// java.lang 패키지에 포함된 클래스들은 import 문장 없이 클래스 이름을 사용할 수 있음.
// (예) java.lang.String, java.lang.Math, java.lang.Sysytem ... 

public class ModifierMain02 {

    public static void main(String[] args) {
        // Ctrl + Shift + O : import 문장 최적화.
        // edu.java.modifier01.AccessTest 객체 생성.
        AccessTest test = new AccessTest(1, 2, 3, 4); // AccessTest 가 있는 패키지와 다르기 때문에 오류발생. import 문을 넣으면 사용가능.
        // private, (package), protected 멤버 변수들은 보이지않음. 직접 접근 불가능.
        test.printMembers();

    }

}
