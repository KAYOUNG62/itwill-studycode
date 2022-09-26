package edu.java.contact.ver02;

//MVC 아키텍쳐 Model에 해당하는 클래스
public class Contact {
    private String name;
    private String phone;
    private String email;

    // 생성자
    public Contact() {

    }

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // getter setter
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

    @Override
    public String toString() {
        return String.format("Contact(name=%s, phone=%s, email=%s)", name, phone, email);
    }

//    public void printcontact() {
//        String info = String.format("Contact(name=%s, phone=%s, email=%s)", name, phone, email);
//        System.out.println(info);
    }

