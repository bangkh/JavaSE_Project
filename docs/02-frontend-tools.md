# 2. React와 Next.js, 빌드 도구

| 구분 | React | Next.js |
| --- | --- | --- |
| 성격 | UI 라이브러리 | React 기반 프레임워크 |
| 주요 역할 | 컴포넌트와 상태로 화면 구성 | 라우팅, 렌더링, 서버 기능 등을 통합 |
| 구성 | 라우터와 빌드 도구 등을 조합 | 프레임워크 규칙과 도구 사용 |

React를 쓴다고 Next.js가 필수인 것은 아님. Next.js 프로젝트에 Vite를 별도로 붙이는 것도 기본 사용법은 아님.

## 도구별 역할

| 도구 | 역할 |
| --- | --- |
| Babel | JSX나 JavaScript 문법을 다른 JavaScript 형태로 변환 |
| Webpack / Rollup | 여러 모듈과 자산의 의존성을 처리해 배포용 파일 구성 |
| ESLint | 규칙 위반과 오류 가능성을 검사 |
| Vite | 개발 서버, 빠른 변경 반영(HMR), 배포 빌드 환경 제공 |

JSX 변환 예:
```jsx
const title = <h1>Java 수업</h1>;
```
브라우저에서 JSX를 그대로 실행하는 것이 아니라 도구가 JavaScript로 변환함. 구체적인 결과는 JSX runtime 설정에 따라 다름.

Vite를 사용하는 이유: 개발 서버와 빌드 설정을 직접 모두 구성하는 부담을 줄이고, 수정 결과를 빠르게 확인하기 위해서.

수업에서 말한 Babel·Webpack·Rollup은 역할을 구분해 이해할 것.
모든 Vite 버전이 Babel과 Rollup을 항상 함께 쓰는 것은 아님.
Vite 8은 Rolldown/Oxc 기반으로 바뀌었고, 이전 Vite 버전은 esbuild/Rollup 중심 구성이었음.
Babel 사용 여부도 플러그인과 설정에 따라 달라짐.

## 확인
- 변환, 번들링, 코드 검사가 각각 다른 작업임을 설명하기
- 기존 프론트 프로젝트의 package.json에서 dev/build/lint 스크립트 확인하기
- 이 저장소에는 프론트 앱을 추가하지 않음: 이번 항목은 비교·개념 수업

참고:
- https://react.dev/learn/creating-a-react-app
- https://nextjs.org/docs
- https://vite.dev/guide/migration.html
- https://vite.dev/guide/philosophy
