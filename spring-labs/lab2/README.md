# Spring Framework 실습 2 — Annotation + XML DI

- 출처: SpringFramework 제출연습문제.docx / Spring 실습2
- 전략: XML에서는 `<context:component-scan>`만 정의
- `@Component`가 붙은 UserService, UserRepository, SecurityService 자동 등록
- `@Autowired` 생성자 주입 / `@Value("MySQL")`
- `registerUser(username, password)`: 비밀번호가 비어 있으면 false, 정상 값이면 저장 후 true
- UserRepository는 과제 취지에 맞춘 **메모리 내 저장소**로, 실제 MySQL 연결을 수행하지 않음
- 실행: JDK 8 이상 + Maven 설치 후 이 디렉터리에서 `mvn test`
