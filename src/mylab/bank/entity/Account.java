package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    protected Account(String accountNumber, String ownerName, double balance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("계좌번호를 입력하세요.");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("소유자 이름을 입력하세요.");
        }
        validateNonNegative(balance);
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        validatePositive(amount);
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        validatePositive(amount);
        if (amount > balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + balance + "원");
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
    }

    protected static void validateNonNegative(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value) || value < 0) {
            throw new IllegalArgumentException("금액은 0 이상의 유한한 숫자여야 합니다.");
        }
    }

    protected static void validatePositive(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value) || value <= 0) {
            throw new IllegalArgumentException("금액은 0보다 큰 유한한 숫자여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return "계좌번호: " + accountNumber + ", 소유자: " + ownerName
                + ", 잔액: " + balance + "원";
    }
}
