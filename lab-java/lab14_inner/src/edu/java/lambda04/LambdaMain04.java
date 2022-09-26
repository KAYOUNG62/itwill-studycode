package edu.java.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMain04 {

    public static void main(String[] args) {
        // Employee를 원소로 갖는 리스트를 선언, 초기화
        List<Employee> employees = Arrays.asList(new Employee(100, "이존규", "개발자", "개발1팀", 300),
                new Employee(101, "김지훈", "개발자", "개발2팀", 301), 
                new Employee(201, "김용훈", "개발자", "개발3팀", 302),
                new Employee(202, "김가영", "디자이너", "개발1팀", 303), 
                new Employee(301, "최은정", "디자이너", "개발2팀", 400),
                new Employee(500, "추지훈", "부사장", "인사팀", 1000));

        // 1. 모든 직원들의 정보를 출력, 한줄에 한명씩
        for (Employee e : employees) {
            System.out.println(e);
        }
        
        employees.stream().forEach(System.out::println);
        System.out.println("\n------------2-------------");

        // 2. 직무 "개발자"인 직원들의 급여 합계를 계산.

        int sum = 0;
        for (Employee e : employees) {
            if (e.getJob().equals("개발자")) {
                sum += e.getSalary();
            }
        }
        System.out.println("일반 합계 = " + sum);
        
        sum = employees.stream().filter(s -> s.getJob().equals("개발자")).mapToInt(Employee::getSalary).sum();  //.mapToInt(s -> s.getSalary())
        System.out.println("람다 합계 = " + sum);

        System.out.println("\n------------3-------------");

        // 3. 부서가 "개발2팀"인 직원들의 급여 평균
        sum = 0;
        int count = 0;
        for (Employee d : employees) {
            if (d.getDept().equals("개발2팀")) {
                sum += d.getSalary();
                count++;
            }
        }
        double deptAvg = (double) sum / count;
        System.out.println("일반 평균 = " + deptAvg);

        double deptAvg2 = employees.stream().filter(d -> d.getDept().equals("개발2팀")).mapToInt(Employee::getSalary)
                .average().getAsDouble();
        
        System.out.println("람다 평균 = " + deptAvg2);
        
        deptAvg2 = 0;
        deptAvg2 = employees.stream().filter(d -> d.getDept().equals("개발2팀")).mapToInt(Employee::getSalary).average().orElseThrow(); 
        //orElseThrow();  >optional > 정상적인 값 또는 exception
        //orElse(0); > optional > 정상적인 값 또는 비정상적인경우 기본값.
        System.out.println("람다 평균 = " + deptAvg2);

        System.out.println("\n------------4-------------");

        // 4. 급여가 400 이상인 직원들의 정보를 한줄씩 출력.
        List<Employee> salaryInfo = new ArrayList<>();
        for (Employee s : employees) {
            if (s.getSalary() >= 400) {
                salaryInfo.add(s);
            }
        }
        for (Employee e : salaryInfo) {
            System.out.println(e);
        }

        
        employees.stream().filter(s -> s.getSalary() >= 400).forEach(System.out::println);


    }

}
