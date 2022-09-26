package edu.java.inner03;

public class BuilderExample {

    public static void main(String[] args) {
        // Book 타입의 변수 선언, 객체 생성
        Book book1 = new Book("하얼빈", "김훈", "소설");
        System.out.println(book1);

        Book book2 = new Book("김훈" , "소설" , "하얼빈");

        //Builder / Factory 패턴을 사용한 객체 생성
        Book book3 = Book.bulider().author("김훈").category("소설").title("하얼빈").build();
        
        System.out.println(book3);
        
        Book book4 = Book.bulider().title("하얼빈").author("김훈").category("소설").build();
        System.out.println(book4);
        
        // 생성자 패턴
        Book book5 = new Book("이상한 변호사 우영우" ,null, null);
        System.out.println(book5);
        
        //Builder / Factory 패턴
        Book book6 =Book.bulider().title("이상한 변호사 우영우").build();
        System.out.println(book6);
        
 
    }

}
