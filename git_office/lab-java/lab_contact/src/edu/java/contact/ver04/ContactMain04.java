package edu.java.contact.ver04;

import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

//MVC 아키텍쳐에서 view에 해당하는 클래스 UI(User Interface)
public class ContactMain04 {
    private Scanner scanner = new Scanner(System.in);
    private ContactDaoImpl dao = ContactDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("***** 연락처 프로그램 Version 0.4 *****");

        ContactMain04 app = new ContactMain04();

        boolean run = true;
        while (run) {
            int n = app.showMainMenu();
            MainMenu menu = MainMenu.getValue(n);
            switch (menu) {
            case QUIT:
                run = false;
                break;
            case SELECT_ALL:
                app.allContacts();
                break;
            case SELECT_BY_INDEX:
                app.selectContactsIndex();
                break;
            case CREATE:
                app.createContact();
                break;
            case UPDATE:
                app.updateContact();
                break;
            case DELETE:
                app.deleteContact();
                break;
            default:
                System.out.println("번호를 다시 입력하세요");
            }
        }
    }

    private void deleteContact() {
        System.out.print("삭제할 인덱스>>");
        int n = inpuNumber();

        
        int result = dao.delete(n);
        if (result == 1) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
    }

    private void updateContact() {
        System.out.print("수정할 인덱스>> ");
        int index = inpuNumber();

        if (!dao.isValidIndex(index)) {
            System.out.println("저장된 연락처가 없습니다.");
            return;
        }
        Contact c = dao.read(index);
        System.out.println("수정전>> " + c);
        System.out.print("수정할 이름 입력>> ");
        String name = scanner.nextLine();

        System.out.print("수정할 전화번호 입력>> ");
        String phone = scanner.nextLine();

        System.out.print("수정할 이메일 입력>> ");
        String email = scanner.nextLine();

        Contact after = new Contact(name, phone, email);
        System.out.println("수정후>> " + after);
        int result = dao.update(index, after);
        if (result == 1) {
            System.out.println("수정 완료");
        } else {
            System.out.println("수정 실패");
        }
    }

    private void createContact() {
        System.out.print("이름 입력>> ");
        String name = scanner.nextLine();

        System.out.print("전화번호 입력>> ");
        String phone = scanner.nextLine();

        System.out.print("이메일 입력>> ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);
        System.out.println(contact);
        int result = dao.create(contact);
        if (result == 1) {
            System.out.println("저장 성공");
        } else {
            System.out.println("저장 실패");
        }

    }

    private void selectContactsIndex() {
        System.out.print("검색할 인덱스>> ");
        int n = inpuNumber();
        Contact c = dao.read(n);
        if (c != null) {
            System.out.println(c);
        } else {
            System.out.println("저장된 정보가 없습니다.");
        }
    }

    private void allContacts() {
        System.out.println("----------- 연락처 리스트 -----------");
        List<Contact> contacts = dao.read();
        for (int n = 0; n < contacts.size(); n++) {
            System.out.println("[" + n + "]" + contacts.get(n));
        }
        System.out.println("-------------------------------------");
    }

    private int showMainMenu() {
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [5]삭제 [0]종료");
        System.out.println("---------------------------------------------------------------");
        System.out.print("메뉴 선택> ");

        return inpuNumber();
    }

    private int inpuNumber() {
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                return num;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
