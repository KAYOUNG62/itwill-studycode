package edu.java.condition02;

public class ConditionMain02 {

    public static void main(String[] args) {
        double x = 3.14;

        // if -else if-else 문장
        if (x > 0) {
            System.out.println("양수");
        } else if (x < 0) {
            System.out.println("음수");
        } else {
            System.out.println("영");
        }

        if (x > 0) {
            System.out.println("positive");
        } else { // 중첩조건문
            if (x < 0) {
                System.out.println("negative");
            } else {
                System.out.println("zero");
            }
        }
    }

}
