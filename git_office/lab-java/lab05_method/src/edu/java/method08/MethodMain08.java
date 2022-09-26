package edu.java.method08;

public class MethodMain08 {

    public static void main(String[] args) {
        //main 메서드 arguments 
        System.out.println("args length = "+ args.length);
        String[] a = new String[0]; // < 원소를 하나도 받지않은 배열 // null; > 배열이 존재하지않음. 
        for (String arg : args) {
            System.out.println(arg);
        }

    }

}
