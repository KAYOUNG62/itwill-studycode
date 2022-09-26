package edu.java.loop07;

public class LoopMain07 {

    public static void main(String[] args) {
        // do- while
        int n = 1;
        do {
            System.out.print(n + " ");
            n++;
        } while (n <= 5);
        System.out.println();

        // while 문은 반복을 시작하기 전에 (반복) 조건을 먼저 검사하기 때문에,
        // 실행블록 ({...}) 이 한 번도 실행디지 않는 경우가 있을 수 있음.
        n = 5;
        while (n < 0) {
            System.out.println(n);
            n--;
        }
        // do- while 문에서는 무조건 실행 블록을 먼저 한번 실행하고 난 후
        //반복을 계속할 지 조건검사를 함.
        
        n=5;
        do {
            System.out.println(n);
            n--;
        } while (n<0);
        System.out.println("end do-while");

        
    }

}
