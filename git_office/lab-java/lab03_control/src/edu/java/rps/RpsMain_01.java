package edu.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsMain_01 {

    public static void main(String[] args) {
        // 조건문 가위바위보 게임
        // random , scanner , if문(9가지의 경우의수 0.1.2)
        // int computer = 난수
        // int user = 스캐너 입력
        // print(computer : user )
        // 누가 이겼는지 (조건문) 출력

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int com = random.nextInt(3);

        System.out.println("가위바위보게임");
        System.out.println("0. 가위  , 1. 바위 , 2. 보");
        System.out.print("선택 >> ");

        int user = scanner.nextInt();

        System.out.println("computer (" + com + ") : user(" + user + ")");

        if (user == 0) { // 사용자 가위
            if (com == 0) {
                System.out.println("무승부");
            } else if (com == 1) {
                System.out.println("패배");
            } else {
                System.out.println("승");
            }
        } else if (user == 1) { // 사용자 바위
            if (com == 0) {
                System.out.println("승");
            } else if (com == 1) {
                System.out.println("무승부");
            } else {
                System.out.println("패");
            }
        } else { // 사용자 보
            if (com == 0) {
                System.out.println("패");
            } else if (com == 1) {
                System.out.println("승");
            } else {
                System.out.println("무승부");
            }
        }

        if (user == com) { // 비긴경우
            System.out.println("무승부");
        } else if (user == 0) { // 사용자 가위
            if (com == 1) {
                System.out.println("패");
            } else {
                System.out.println("승");
            }
        } else if (user == 1) { // 사용자 바위
            if (com == 0) {
                System.out.println("승");
            } else {
                System.out.println("패");
            }
        } else { // 사용자 보
            if (com == 0) {
                System.out.println("패");
            } else {
                System.out.println("승");
            }

        }

        if (user == com) {
            System.out.println("무승부");
        } else if ((user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1)) {
            System.out.println("승");
        } else {
            System.out.println("패");
        }

        int diff = user = com;
        if (diff == 0) {
            System.out.println("무승부");
        } else if (diff == 1 || diff == -2) {
            System.out.println("승");
        } else {
            System.out.println("패");
        }
    }
}
