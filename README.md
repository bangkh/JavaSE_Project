# JavaSE_Project

LG CNS AM INSPIRE CAMP 7기 Java 수업 실습

수업 자료: https://github.com/inspirecamp7/JavaSE_Project

## 구성

- chapter1: 자료형, 연산자, 입력
- chapter2: 조건문, 반복문
- chapter3: 클래스와 객체
- chapter4: 배열
- chapter5: 상속, 추상 클래스, 인터페이스
- chapter6: 컬렉션
- basic: 개념별 예제

## 실행

JDK 21 기준. 압축을 푼 폴더에서 PowerShell을 열고 실행

```powershell
java -version
javac -version
powershell -NoProfile -ExecutionPolicy Bypass -File .\build.ps1
java -cp out chapter1.first.HelloWorld
```

다른 예제는 마지막 클래스 이름을 바꿔서 실행. 코드 수정 후에는 다시 컴파일

```powershell
java -cp out chapter1.first.MyCalculatorUsingScanner
java -cp out chapter1.first.TestString Kyungho
```

계산기는 숫자를 하나씩 입력하고 Enter. TestString은 뒤에 이름을 전달해야 함

IntelliJ에서는 이 폴더를 열고 JDK 지정 → src를 Sources Root로 지정 → main 실행

out 폴더와 IDE 개인 설정은 Git에 올리지 않음
