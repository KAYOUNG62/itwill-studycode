package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04_1 {

	public static void main(String[] args) {
		// Java 시험 점수(정수)를 입력
		// SQL 시험 점수를 입력
		// JSP 시험 점수를 입력

		Scanner scanner = new Scanner(System.in);
		System.out.print("Java 시험 점수=");
		int number = scanner.nextInt(); 
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("SQL 시험 점수=");
		int number1 = scanner.nextInt(); 
		
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("JSP 시험 점수=");
		int number2 = scanner.nextInt(); 
		
		// 세 과목의 총점(정수)을 계산하고 출력
		// 세 과목의 평균(실수)을 계산하고 출력.

		int s = number+number1+number2 ;
		System.out.println("총점="+s);
		
		double x = s/3;
		System.out.println(x);

	}

}
