# 실습 2: 도서관 관리 시스템

- `mylab.library.entity.Book`: 도서 정보, 대출/반납 상태 관리
- `mylab.library.entity.Library`: 도서 등록, 검색, 대출/반납, 통계
- `mylab.library.control.LibraryManagementSystem`: 실행 예제

## 실행 (JDK 8)

```bash
mkdir -p out
javac -encoding UTF-8 -source 8 -target 8 -d out src/mylab/library/entity/*.java src/mylab/library/control/*.java
java -cp out mylab.library.control.LibraryManagementSystem
```

수업 예제와 별도인 `src/mylab/library`만 컴파일합니다. 도서 목록은 `ArrayList`로 관리합니다.
