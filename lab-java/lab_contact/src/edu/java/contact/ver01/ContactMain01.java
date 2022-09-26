package edu.java.contact.ver01;

import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

public class ContactMain01 {
    // 상수
    private static final int MAX_LENGTH = 3; // 저장할 수 있는 연락처의 최대 개수(배열길이)

    // field
    private Scanner scanner = new Scanner(System.in); // 입력도구
    private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처들의 배열
    private int count = 0; // 배열에 저장된 연락처의 개수. 연락처가 추가될때마다 증가
//  지역변수가 아닌 멤버변수로 설정한 이유 : 전체리스트와 새연락처 같은 여러곳에서 사용되기 때문에 멤버변수로 설정

//  default constructor  / new Scanner(system.in) 을 붙혀서 처리할 경우 아래 생성자를 만들 필요는 없음.
//  public ContactMain01() {
//    scanner = new Scanner(System.in);
//    }

//   static 은 사용되지않으면 사라지는 heap 영역이 아닌 method에 저장되기 때문에 static이 많아질수록 메모리를 많이 차지함. 
    public static void main(String[] args) {
        System.out.println("**** 연락처 프로그램 Version 0.1 ****");

        ContactMain01 app = new ContactMain01(); // 객체의 주소를 저장하기 위해 선언. static 이 붙지않은 method를 사용하기 위해 객체생성.

        boolean run = true; // 프로그램을 계속 실행할지 종료할지를 결정 하기위한 변수.
        while (run) {
            // 1. 메인 메뉴 보여주기
            app.showMainMenu();

            // 2. 메뉴 입력
            int n = Integer.parseInt(app.scanner.nextLine());
            MainMenu menu = MainMenu.getValue(n);

            // 3. switch-case
            switch (menu) {
            case QUIT:
                run = false;
                break;
            case SELECT_ALL:
                app.selectAllContacts();
                break;
            case SELECT_BY_INDEX:
                app.selectContactByIndex();
                break;
            case CREATE:
                app.insertNewContact();
                break;
            case UPDATE: // 수정기능
                app.updateContact();

                break;
            default:
                System.out.println("지원하지 않는 메뉴 번호입니다. 다시 선택하세요.");
            }
        }

        System.out.println("**** 프로그램 종료 ****");

    } // main method 종료

    private void showMainMenu() { // main이 static이기 때문에 static이 안붙어 있을 경우 객체가 생성된 이후에만 사용될 수 있음.
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("[1]전체리스트 | [2]인덱스검색 | [3]새연락처| [4]수정 | [0]종료");
        System.out.println("--------------------------------------------------------------");
        System.out.print("메뉴 선택 > ");

    }

    private void selectAllContacts() {
        // 배열 contacts에 저장된 Contact 객체들을 출력.
        System.out.println();
        System.out.println("--------------------- 연락처 전체 리스트 ---------------------");
        for (int i = 0; i < count; i++) {
            // 베열의 길이만큼 반복하는 것이 아니라, 배열에 실제로 저장된 연락처 개수 만큼만 반복해서 사용.
            contacts[i].printContact();
        }
        System.out.println("--------------------------------------------------------------");
    }

    private void selectContactByIndex() {
        // TODO NullPointerException, ArrayIndexOutOfBoundsException 발생할 수 있음.

        if(count == 0 ) {
        System.out.println("등록된 연락처가 없습니다."); 
        return;} 
        // 검색할 인덱스 입력
        

        System.out.print("현재 저장되어있는 인덱스는" + (count - 1) + "입니다. 0부터 입력 가능.");
        System.out.print("검색할 인덱스>> ");
        int index = Integer.parseInt(this.scanner.nextLine());

        if (index < 0 || index >= count) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다. ");
            return; // 메서드 종료
        }
        // 해당 인덱스의 연락처 정보를 출력.
        contacts[index].printContact();

    }

    private void insertNewContact() {
        // TODO ArrayIndexOutofBoundsexception 오류 발생할 수 있음.
        // 이름, 전화번호, 이메일 입력

        if (count >= MAX_LENGTH) {
            System.out.println("저장공간 부족");
            return;
        }
        System.out.print("이름 입력>> ");
        String name = scanner.nextLine();
        System.out.print("전화번호 입력>> ");
        String phone = scanner.nextLine();
        System.out.print("이메일 입력>> ");
        String email = scanner.nextLine();

        // Contact 객체 생성
        Contact c = new Contact(name, phone, email);

        // 배열에 추가
        contacts[count] = c;
        count++; // 배열에 저장된 연락처 개수를 1 증가

    }

    private void updateContact() {
        // TODO NullPointerException, ArrayIndexOutOfBoundsException 발생할 수 있음.

        // 수정할 인덱스 입력
        if(count == 0 ) {
        System.out.println("등록된 연락처가 없습니다."); 
        return;} 
        
        System.out.print("현재 저장되어있는 인덱스는" + (count - 1) + "입니다. 0부터 입력 가능합니다.");
        
        System.out.print("수정할 연락처 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= count) {
            System.out.println("해당 인덱스에는 수정할 연락처 정보가 없습니다. ");
            return; // 메서드 종료
        }

        // 수정전 연락처 정보 출력
        System.out.print("수정전>>> ");
        contacts[index].printContact();

        // 수정할 이름/ 전화번호/이메일 입력
        System.out.print("수정할 이름>> ");
        String name = scanner.nextLine();

        System.out.print("수정할 전화번호>> ");
        String phone = scanner.nextLine();

        System.out.print("수정할 이메일>> ");
        String email = scanner.nextLine();

        // 연락처 정보 업데이트
        contacts[index].setName(name);
        contacts[index].setPhone(phone);
        contacts[index].setEmail(email);

        // 수정후 연락처 정보 출력
        System.out.print("수정 후>>> ");
        contacts[index].printContact();

    }

}

// class 종료

// 숫자가 아닌 문자열을 입력할 경우 NumberFormatException 오류발생. 
