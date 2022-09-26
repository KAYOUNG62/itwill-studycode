package edu.java.class06;

public class Account {
    // field
    int accountNo; // 계좌번호
    double balance; // 잔고

    // constructor - argument 2개를 갖는 생성자.
    // 매개변수 = 파라미터

    public Account(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    /**
     * 입금(deposit)
     * 
     * @param amount 입금액
     * @return 입금 후 잔액을 리턴.
     */
    public double deposit(double amount) {
        balance += amount;
        System.out.println("입금할 금액 : " + amount);
        return balance;
    }

    /**
     * 출금(withdraw)
     * 
     * @param amount 출금액
     * @return 출금 후 잔액을 리턴.
     */
    public double withdraw(double amount) {
        balance -= amount;
        System.out.println("출금할 금액 : " + amount);
        return balance;

    }

    /**
     * 이체(transfer)
     * 
     * @param to     이체할 계좌 객체(Account 타입)
     * @param amount 이체할 금액
     * @return true(이체 성공).
     */
    public boolean transfer(Account to, double amount) {
        // 이체 : 내 계좌 출금, 상대방 계좌 입금
        balance -= amount;
        to.balance += amount;
        // this.withdraw(amount); 대체가능
        // to.deposit(amount); 대체가능
        System.out.println(amount + "원 이체되었습니다.");

        return true;
    }

    /**
     * 계좌 정보 출력(printAccountInfo). 계좌 번호와 잔액을 출력.
     */
    public void printAccountInfo() {
        System.out.println("--- 계좌 정보 ---");
        System.out.println("계좌번호: " + this.accountNo);
        System.out.println("잔고: " + this.balance);
    }
}
