# JavaSE_Project

LG CNS AM INSPIRE CAMP 7기 Java 수업 실습
수업 자료: https://github.com/inspirecamp7/JavaSE_Project

## 수업 순서

| 순서 | 정리 및 실습 |
| --- | --- |
| 1 | [백엔드 과정 개요](docs/01-backend.md) |
| 2 | [React, Next.js, 빌드 도구](docs/02-frontend-tools.md) |
| 3 | [Windows / Mac 개발환경 설치](docs/03-setup.md) |
| 4 | [GitHub CLI 인증과 Push](docs/04-github.md) |
| 5 | [클래스 다이어그램과 관계](docs/05-class-diagram.md) |
| 6 | [캡슐화](docs/06-encapsulation.md) |
| 7 | [생성자](docs/07-constructors.md) |

1~4번은 개념·환경 준비, 5~7번은 Java 코드 실습.
문서는 따라 할 절차와 예상 결과이며, 개인 PC 설치 및 CLI 인증을 완료했다는 기록은 아님.

## 실행

수업 기준은 **JDK 8**. java와 javac 버전이 모두 1.8인지 확인.

Windows PowerShell:

```powershell
java -version
javac -version
powershell -NoProfile -ExecutionPolicy Bypass -File .\build.ps1
```

Mac:

```bash
java -version
javac -version
bash build.sh
```

컴파일 후 아래 순서로 실행:

```text
java -cp out lesson.step05.RelationshipDemo
java -cp out lesson.step06.EncapsulationDemo
java -cp out lesson.step07.ConstructorDemo
```

기본 빌드는 이번 수업의 src/lesson만 컴파일. 기존 예제 전체는 Windows에서 build.ps1 -All, Mac에서 bash build.sh --all 사용.

## 폴더 구분

- docs: 수업 순서대로 정리한 문서
- src/lesson: 이번 5~7번 실습용 보충 예제
- src/chapter1 ~ chapter6, src/basic: 강사 저장소에서 가져온 전체 예제
- out: 컴파일 결과, Git에서 제외
