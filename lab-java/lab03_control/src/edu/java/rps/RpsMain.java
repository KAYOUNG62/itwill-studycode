package edu.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsMain {

    public static void main(String[] args) {
        // 조건문 가위바위보 게임
        // random , scanner , if문(9가지의 경우의수 0.1.2)
        // int computer = 난수
        // int user = 스캐너 입력
        // print(computer : user )
        // 누가 이겼는지 (조건문) 출력

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("가위바위보 게임");
        System.out.println("숫자를 입력하세요 = 0.가위 1.바위 2.보");

        System.out.printf("user = ");
        int user = scanner.nextInt();

        int com = random.nextInt(3);
        System.out.println("computer = " + com);

        System.out.println("computer : user = " + com + " : " + user);

        if ((user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1)) {
            System.out.println("승리");
        } else if ((user == 0 && com == 1) || (user == 1 && com == 2) || (user == 2 && com == 0)) {
            System.out.println("패배");
        } else if (user == com) {
            System.out.println("무승부");
        } else {
            System.out.println("숫자를 다시 입력해주세요");
        }
    }
}

