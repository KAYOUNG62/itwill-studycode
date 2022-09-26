package edu.java.contact.ver01;

public class Contact {
    // 데이터 클래스. 이름, 전화번호, 이메일 저장할 클래스
    // field
    private String name;
    private String phone;
    private String email;

    // 기본생성자 (default constructor)
    public Contact() {
    }

    // argument 를 갖는 생성자
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // getters / setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 연락처 정보 출력 기능
    public void printContact() {
        String info = String.format("Contact(name=%s , phone=%s , email=%s)", this.name, this.phone, this.email); // 두번째자리 가변인수
        System.out.println(info);
    }

}
