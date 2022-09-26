package edu.java.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        Account account1 = new Account(123456, 10000);
        Account account2 = new Account(123, 30000);

        account1.printAccountInfo();
        System.out.println();
        System.out.println("입금 후 잔액: " + account1.deposit(5000));
        System.out.println();
        System.out.println("출금 후 잔액: " + account1.withdraw(7000));
        
        System.out.println();
        
        account1.transfer(account2, 3000);

        System.out.println();
        account1.printAccountInfo();
    }

}
