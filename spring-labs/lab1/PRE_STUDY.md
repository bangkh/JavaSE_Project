# Spring Framework 사전 학습 정리 (2026-11-24 실습 1 대비)

## 1. 프레임워크와 라이브러리
- **라이브러리**: 개발자가 라이브러리 함수를 호출해 사용한다(제어 흐름은 애플리케이션).
- **프레임워크**: 프레임워크가 애플리케이션의 진입점과 객체 생명주기/호출 흐름 일부를 관리한다(역전된 제어).

## 2. IoC (Inversion of Control)
- 객체 생성과 연결, 생명주기 관리를 애플리케이션 내부의 `new` 호출이 아니라 Spring IoC 컨테이너에 위임한다.
- Spring에서는 `ApplicationContext`에서 Bean을 조회할 수 있다.

## 3. DI (Dependency Injection)
- 객체가 필요한 의존 객체를 직접 생성하지 않고 외부에서 제공받는다.
- **Setter Injection**: 기본 생성자로 객체 생성 후 `setShoppingCart(cart)` 같은 setter로 주입. 의존성이 선택적이거나 교체 가능할 때 활용.
- **Constructor Injection**: 생성자 인자로 의존성을 전달. 필수 의존성을 생성 시점에 보장하기 쉽다.
- 실습 1: `product1`은 setter 방식, `product2`는 constructor 방식. `ShoppingCart`, `OrderService`는 XML property 주입.

## 4. JUnit / Spring Test
- JUnit은 메서드별 단위 테스트를 작성·실행하는 도구. `@Test`와 `assertEquals`, `assertNotNull` 등을 사용한다.
- Spring Test의 `@RunWith(SpringJUnit4ClassRunner.class)`와 `@ContextConfiguration`은 테스트에서 Spring 컨테이너를 띄우고 Bean을 주입받도록 돕는다.
- 실습 1 검증: 장바구니 상품 2개, 첫 번째 이름 '노트북', 두 번째 이름 '스마트폰', 합계 950000.

## 5. Maven과 빌드 도구
- Java 빌드 도구는 의존성 다운로드/버전관리, 컴파일, 테스트, 패키징 작업을 자동화한다.
- Maven은 `pom.xml`에 의존성과 빌드 설정을 선언한다.
- 이 과제의 실행: `cd spring-labs/lab1` 후 `mvn test`.

## 6. XML과 Spring 설정
- XML(Extensible Markup Language)은 계층적 구조를 표현하는 마크업 형식이다.
- Spring XML 설정에서는 `<bean>`으로 객체를 선언하고 `<property>` 또는 `<constructor-arg>`로 의존성을 주입한다.
- 장점: Java 코드 변경 없이 객체 연결 구성을 조정할 수 있다.
- 단점: XML 설정량이 증가하고 형식 오류를 찾기 어려울 수 있다.
- 실습 2는 `<context:component-scan>`으로 XML 양을 줄이고, 실습 3은 `@Configuration` / `@Bean`으로 Java 기반 설정으로 전환한다.

## 직접 비교
| 방식 | 실습 | 객체 등록 방식 | DI 방식 |
|---|---|---|---|
| XML 설정 | Spring 실습1 | `<bean>` | `<property>`, `<constructor-arg>` |
| Annotation + XML | Spring 실습2 | `@Component`, component-scan | `@Autowired`, `@Value` |
| Java Config | Spring 실습3 | `@Configuration`, `@Bean` | 설정 메서드의 파라미터 주입 |

> 참고: 실습용 코드는 Java 8 호환 및 Spring Framework 5.3.39로 작성했으며, 강사가 제공한 기존 ZIP 예제는 Spring Framework 4.3.22.RELEASE를 사용한다.
