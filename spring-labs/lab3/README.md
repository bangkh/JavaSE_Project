# Spring Framework 실습 3 — Java Configuration DI

- 출처: SpringFramework 제출연습문제.docx / Spring 실습3
- `@Configuration` / `@Bean`으로 EmailService, SmsService, NotificationManager 등록
- 이메일 설정: smtp.gmail.com:587
- SMS 공급자: SKT
- `NotificationConfigTest`는 Bean 생성, 주입, 속성 및 메서드 호출을 JUnit 4 + Spring Test로 검증
- **주의**: `sendEmail`, `sendSms`는 실습용 콘솔 메시지 출력이며 실제 발송은 하지 않음
- 실행: JDK 8 이상 + Maven 설치 후 이 디렉터리에서 `mvn test`
