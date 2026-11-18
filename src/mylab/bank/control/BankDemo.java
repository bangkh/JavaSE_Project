package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("=== 계좌 생성 ===");
        SavingsAccount savings = bank.createSavingsAccount("홍길동", 10000, 0.03);
        CheckingAccount checking = bank.createCheckingAccount("김철수", 20000, 5000);
        SavingsAccount anotherSavings = bank.createSavingsAccount("이영희", 30000, 0.02);
        bank.printAllAccounts();

        try {
            System.out.println("=== 입금/출금 테스트 ===");
            bank.deposit(savings.getAccountNumber(), 5000);
            bank.withdraw(checking.getAccountNumber(), 3000);

            System.out.println("=== 이자 적용 테스트 ===");
            savings.applyInterest();

            System.out.println("=== 계좌 이체 테스트 ===");
            bank.transfer(anotherSavings.getAccountNumber(), checking.getAccountNumber(), 5000);
            bank.printAllAccounts();
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw(checking.getAccountNumber(), 6000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        try {
            bank.transfer(checking.getAccountNumber(), savings.getAccountNumber(), 6000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
