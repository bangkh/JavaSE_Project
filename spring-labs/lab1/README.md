# Spring Framework 실습 1 — XML 의존성 주입

- 출처: SpringFramework 제출연습문제.docx / Spring 실습1
- 방식: Product(product1)는 setter injection, Product(product2)는 constructor injection
- ShoppingCart, OrderService는 XML setter injection
- 설정 파일: `src/main/resources/mylab-order-di.xml`
- 검증: JUnit 4 / Spring Test, 장바구니 2개 상품·총합 950000원
- 실행: JDK 8 이상 + Maven 설치 후 이 디렉터리에서 `mvn test`
- SMTP / DB 등 외부 시스템 불필요. Spring 5.3.39는 Java 8 호환.
