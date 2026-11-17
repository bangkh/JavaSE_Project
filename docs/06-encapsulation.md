# 6. 캡슐화

실습 파일: [EncapsulationDemo.java](../src/lesson/step06/EncapsulationDemo.java)
기존 수업 예제: [Person.java](../src/chapter3/oop/Person.java), [MyDate.java](../src/chapter3/oop/MyDate.java)

필드를 private로 감추고 메서드로 접근을 제어함.
Getter는 값 조회, Setter는 값 변경. 모든 필드에 Setter를 반드시 만들어야 하는 것은 아님.

예제에서 setAge(-1)은 예외를 발생시키고 기존 나이 값은 유지함.
단순히 Getter/Setter를 만드는 것보다 유효한 상태를 지키는 것이 중요.

```java
public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Age must be 0 or greater.");
    }
    this.age = age;
}
```

this.age는 객체의 필드, age는 메서드 매개변수.
예외와 try/catch는 잘못된 값 처리 결과를 보여주기 위한 보조 코드. 자세한 예외 문법은 이후 수업에서 다룸.

## 실행
```text
java -cp out lesson.step06.EncapsulationDemo
```
예상 출력:
```text
KyungHo / 20
Age must be 0 or greater.
Age after rejected input: 20
```

20은 예제용 값이며 개인 정보 기록이 아님.

## 직접 확인
1. 정상 입력으로 이름과 나이가 바뀌는지 확인
2. -1을 넣었을 때 이전 값 20이 유지되는지 확인
3. 이름에 빈 문자열을 넣으면 왜 거부되는지 설명
4. 원본 MyDate의 setMonth가 1~12를 검사하는 부분과 비교
