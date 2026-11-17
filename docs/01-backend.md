# 1. 백엔드 과정 개요

| 구분 | 역할 | 예 |
| --- | --- | --- |
| Java | 프로그램을 작성하는 언어 | 클래스, 객체, 조건문, 컬렉션 |
| Spring Framework | 객체 관리와 웹 개발 등을 지원하는 프레임워크 | DI, MVC, 트랜잭션 |
| Spring Boot | Spring 애플리케이션 설정·실행을 간편하게 구성 | 자동 설정, starter, 내장 서버 |

학습 흐름: Java 문법 → 객체지향 → Spring의 객체 관리 → 웹 요청 처리 → DB 연동.

게시판으로 생각하면 React/Next.js 화면이 글 목록을 요청하고, Java/Spring 서버가 조회를 처리하며 MariaDB가 데이터를 보관함.
Next.js도 서버 기능을 가질 수 있으므로 모든 서비스가 이 구성을 반드시 쓰는 것은 아님.

현재 프로젝트는 main 메서드로 실행하는 Java SE 예제. Spring 서버나 DB 연결 코드는 아직 없음.
이번 JDK 8 기준을 최신 Spring Boot에도 그대로 적용하면 안 됨. Spring Boot 3.x/4.x는 Java 17 이상이 필요하므로 이후 수업에서 지정한 버전으로 별도 설정.

## 확인
- Java는 언어, Spring은 프레임워크라고 설명할 수 있는가?
- Spring Boot가 Java를 대체하는 것이 아니라 Spring 앱의 구성을 돕는다는 점을 이해했는가?

참고: https://docs.spring.io/spring-boot/system-requirements.html
