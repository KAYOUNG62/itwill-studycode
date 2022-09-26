package edu.java.class06;

public class lassMain06_2 {

    public static void main(String[] args) {
        // 해답지? 설명?
        Account account1 = new Account(123456, 1000);
        System.out.println(account1);

        account1.printAccountInfo(); // 계좌정보 출력

        double money = account1.deposit(10000); // 입금
        System.out.println("입금후 잔고: " + money);
        System.out.println();
        
        account1.printAccountInfo(); // 계좌정보 출력

        money = account1.withdraw(5000); // 출금
        System.out.println("출금후 잔고: " + money);
        System.out.println();

        // 이체할 계좌 생성
        Account account2 = new Account(654321, 1000);
        account2.printAccountInfo(); // 계좌정보 출력
        
        
        //account1 에서 account2로 5000원 이체
        System.out.println();
        
        account1.transfer(account2, 5000);
        
        account1.printAccountInfo(); // 계좌정보 출력
        account2.printAccountInfo(); // 계좌정보 출력

    }

}
