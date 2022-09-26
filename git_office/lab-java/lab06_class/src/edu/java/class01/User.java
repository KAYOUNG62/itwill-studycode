package edu.java.class01;

//클래스 : 데이터 + 기능 + 생성자 => 데이터 타입

public class User {
    // 객체가 가지는 속성들(데이터)
    String userId;
    String possword;
    int age;

    // 생성자(constructor)
    // 객체를 메모리에 생성하고 초기화해 주는 기능을 담당.
    // 모든 클래스는 생성자가 적어도 하나 이상은 있어야함.
    // 클래스를 작성할 때 생성자를 하나도 정의하지 않으면, 자바 컴파일러가 기본생성자를 자동으로 만들어줌.
    // 클래스를 작성할때 생성자를 정의하면, 자바 컴파일러는 기본 생성자를 자동으로 만들지않음.
    // 생성자의 이름은 클래스의 이름과 동일. 생성자는 리턴 타입을 사용하지 않음!

    // 기본 생성자(default constructor) - argument 를 갖지않는 생성자
    // 모든 속성들을 그 타입에 기본값으로 초기화함.
    // 숫자 타입 기본값 : 0, boolean 타입 기본값 : false, 참고타입 기본값 : null
    public User() { // constructor1
        // DO nothing.
    }

    // argument 를 갖는 생성자
    public User(String userId, String password, int age) { // constructor2
        this.userId = userId;
        this.possword = password;
        this.age = age;
    }

    public User(String userId, String password) { // constructor3
//        this.userId = userId;
//        this.possword = password;
        this(userId, password, 0); // constructor2를 호출. (2)의 대한 예시.
    }

    public User(String userId) { /// constructor4
//       this.userId = userId;
        this(userId, null, 0); // constructor2를 호출.
//        this(userId, null) > constructor3를 호출.
    }
    // 생성자 오버로딩 (overloading) : 파라미터가 다른 생성자를 여러개 정의하는 것.
    
    // this의 의미:
    // (1) 생성된 객체의 주소 : 예) this.userId, this,password, ...
    // (2) 생성자: overloading 된 다른 생성자를 사용할 때

}
