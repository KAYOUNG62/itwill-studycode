package edu.java.contact.ver02;

import java.util.Scanner;
import edu.java.contact.menu.MainMenu;

import static edu.java.contact.ver02.ContactDaoImpl.MAX_LENGTH;

public class ContactMain02 {

    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl con = ContactDaoImpl.getInstance(); // 컨트롤러 클래스(연락처 저장,수정,검색)

    public static void main(String[] args) {
        System.out.println("***** 연락처 프로그램 Version 0.2 *****");

        ContactMain02 app = new ContactMain02();

        boolean run = true;
        while (run) {
            int n = app.showMainMenu();
            MainMenu menu = MainMenu.getValue(n);
            switch (menu) {
            case SELECT_ALL:
                app.select();
                break;
            case SELECT_BY_INDEX:
                app.selcetByIndex();
                break;
            case CREATE:
                app.contactCreate();
                break;
            case UPDATE:
                app.contactUpdate();
                break;
            case QUIT:
                run = false;
                break;
            default:
                System.out.println("다시 선택해주세요.");
            }
        }

        System.out.println("*** 프로그램 종료 ***");
    }

    private int showMainMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
        System.out.println("-----------------------------------------------");
        System.out.print("메뉴 선택> ");

        int n = Integer.parseInt(scanner.nextLine());
        return n;
    }

    private void select() {
        Contact[] contacts = con.select();
        System.out.println("----- 연락처 전체 리스트 -----");
        for (Contact c : contacts) {
            System.out.println(c);
        }
        System.out.println("-------------------------");
    }

    private void selcetByIndex() {
        System.out.print("검색할 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        Contact c = con.select(index);
        System.out.println(c);
    }

    private void contactCreate() {
//        
//        if (!con.isMemoryAvailable) {
//            System.out.println("새 연락처를 저장할 공간이 부족합니다.");
//            return;
//        }
        if (con.getCount() == MAX_LENGTH) {
            System.out.println("연락처를 저장할 메모리가 부족합니다.");
            return;
        }
        System.out.print("이름 입력>> ");
        String name = scanner.nextLine();
        System.out.print("전화번호 입력>> ");
        String phone = scanner.nextLine();
        System.out.print("이메일 입력>> ");
        String email = scanner.nextLine();

        Contact c = new Contact(name, phone, email);
        int result = con.create(c); 
        if (result == 1) {
            System.out.println("연락처 저장 성공");
        } else {
            System.out.println("연락처 저장 실패");
        }
    }

    private void contactUpdate() {
        
        int result = con.getCount();
        if (result == 0) {
            System.out.println("저장된 연락처가 없습니다.");
            return;
        } 
  
        System.out.print("수정할 연락처 인덱스>> ");
        int index = Integer.parseInt(scanner.nextLine());
        Contact c = con.select(index);
        
        if (c == null) {
            System.out.println("해당 인덱스에는 저장된 정보가 없습니다. ");
            return;
        }

        System.out.println(c);
        System.out.print("수정할 이름>> ");
        String name = scanner.nextLine();
        System.out.print("수정할 전화번호>> ");
        String phone = scanner.nextLine();
        System.out.print("수정할 이메일>> ");
        String email = scanner.nextLine();

        int result2 = con.update(index, name, phone, email);
        if (result2 == 1) {
            System.out.println("연락처 수정 완료");
        } else {
            System.out.println("연락처 수정 실패");
        }
    }

}
