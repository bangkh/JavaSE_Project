# 실습 3: 은행 계좌 관리 시스템

- Account: 추상 부모 클래스, 잔액 및 입출금
- SavingsAccount: 이자율과 이자 적용
- CheckingAccount: 출금 한도 확인
- Bank: 계좌 개설·검색·입출금·송금
- mylab.bank.exception: 계좌 없음, 잔액 부족, 출금 한도 초과 예외
- BankDemo: 기본 기능과 예외 상황 실행

## 실행 (JDK 8)

    mkdir -p out
    javac -encoding UTF-8 -source 8 -target 8 -d out src/mylab/bank/exception/*.java src/mylab/bank/entity/*.java src/mylab/bank/control/*.java
    java -cp out mylab.bank.control.BankDemo

한도 검증 후 출금 처리하며, 송금 전 송금·수취 계좌를 모두 조회합니다.
