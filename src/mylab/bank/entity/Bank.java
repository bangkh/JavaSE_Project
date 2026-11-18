package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private final List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<Account>();
        nextAccountNumber = 1000;
    }

    public SavingsAccount createSavingsAccount(String ownerName, double balance, double interestRate) {
        SavingsAccount account = new SavingsAccount(nextNumber(), ownerName, balance, interestRate);
        accounts.add(account);
        System.out.println("저축 계좌가 생성되었습니다: " + account);
        return account;
    }

    public CheckingAccount createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        CheckingAccount account = new CheckingAccount(nextNumber(), ownerName, balance, withdrawalLimit);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + account);
        return account;
    }

    private String nextNumber() { return "AC" + (nextAccountNumber++); }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) return account;
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public List<Account> getAllAccounts() { return new ArrayList<Account>(accounts); }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String from, String to, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("송금 금액은 0보다 커야 합니다.");
        }
        Account sender = findAccount(from);
        Account receiver = findAccount(to);
        if (sender == receiver) throw new IllegalArgumentException("동일한 계좌로 송금할 수 없습니다.");
        sender.withdraw(amount);
        receiver.deposit(amount);
        System.out.println(amount + "원이 " + from + "에서 " + to + "로 송금되었습니다.");
    }

    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account account : accounts) System.out.println(account);
        System.out.println("===================");
    }
}
