# 실습 4: 출판물 관리와 쇼핑카트

- Publication 및 하위 클래스 Magazine, Novel, ReferenceBook
- ManageBook: 다형성, 유형별 가격 할인, 출판물 통계
- ShoppingCart: 장바구니 추가·삭제, 유형별 할인율, 수량 통계
- StatisticsAnalyzer: 유형별 평균가·구성 비율·특정 연도 비율

## 실행 (JDK 8)

    mkdir -p out
    javac -encoding UTF-8 -source 8 -target 8 -d out src/mylab/book/entity/*.java src/mylab/book/control/*.java
    java -cp out mylab.book.control.ManageBook
    java -cp out mylab.book.control.ShoppingCart

## 문제 문서의 표기 차이

문서 설명에는 '3번째 도서(인덱스 2)' 가격 변경이라고 적혀 있지만,
Sample Run은 마지막 도서인 '작별하지않는다'가 15,120원에서 12,096원으로
변경되며 소설 평균 11,974원이 나오는 예시입니다.
여기서는 Sample Run과 일치하도록 마지막 소설의 가격을 20% 할인했습니다.
