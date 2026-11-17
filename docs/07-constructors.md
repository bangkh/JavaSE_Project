# 7. 생성자의 역할과 오버로딩

실습 파일: [ConstructorDemo.java](../src/lesson/step07/ConstructorDemo.java)
기존 수업 예제: [Person.java](../src/chapter3/oop/Person.java)

생성자는 new로 객체를 만들 때 초기 상태를 설정.
클래스와 이름이 같고 반환 타입이 없음. void를 쓰면 생성자가 아닌 메서드가 됨.

## 매개변수 없는 생성자와 기본 생성자
- 생성자를 하나도 선언하지 않으면 컴파일러가 기본 생성자를 제공함.
- 직접 작성한 Student()는 엄밀히 말해 명시적 무인자 생성자.
- 수업에서 이를 '기본생성자'라고 부르기도 하지만 자동 생성 여부는 구분해야 함.
- 매개변수 있는 생성자만 선언하면 Student()가 자동 추가되지 않음.

## 생성자 오버로딩

```java
new Student();
new Student("KyungHo");
new Student("KyungHo", 20);
```

이름은 같지만 매개변수 개수 또는 타입이 달라 서로 다른 생성자가 선택됨.
매개변수 이름만 바꾸는 것으로는 오버로딩할 수 없음.

예제의 this("Unknown", 0)는 같은 클래스의 다른 생성자 호출.
JDK 8에서는 this(...) 호출을 생성자의 첫 문장에 둬야 함.
초기화와 검증을 두 인자 생성자에 모아 중복을 줄임.

## 실행
```text
java -cp out lesson.step07.ConstructorDemo
```
예상 출력:
```text
Unknown / 0
KyungHo / 0
KyungHo / 20
```

## 직접 확인
- 무인자 생성자를 주석 처리하면 new Student()가 왜 실패하는지 설명
- Setter는 생성 후 변경, 생성자는 생성 시 초기화라는 차이 설명
- new Student("KyungHo", -1)이 왜 유효한 객체를 반환하지 못하는지 설명
