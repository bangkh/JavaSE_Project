# 4. GitHub CLI 인증과 Push

현재 원격 저장소: https://github.com/bangkh/JavaSE_Project
이미 만들어진 저장소이므로 같은 이름으로 다시 생성할 필요 없음.
현재 GitHub 반영은 연결 도구로 진행한 것이며, 아래 CLI 실습을 개인 PC에서 수행했다는 뜻은 아님.

## 1) 인증

```text
gh auth login --hostname github.com --git-protocol https
```

대화형 메뉴에서 인증 방법 선택.
- 브라우저 방식: 표시된 일회용 코드를 브라우저에 입력하고 **bangkh**로 승인. 인증 후 CLI가 자격 증명을 관리.
- 수업에서 개인 토큰(PAT)을 직접 입력하라고 했다면: GitHub Settings → Developer settings → Personal access tokens에서 수업 요구에 맞는 토큰을 발급하고, CLI의 'Paste an authentication token' 선택 후 입력. gh auth login 공식 문서의 classic token 최소 scope는 repo, read:org, gist. 만료일을 지정하고 토큰은 README·소스·채팅에 적지 않기.
- Fine-grained token은 classic scope와 다른 방식이므로 같은 체크박스가 있다고 생각하지 말 것. 학교에서 지정한 인증 방식에 맞추기.

```text
gh auth status
gh api user --jq .login
gh auth setup-git
```

로그인이 bangkh인지 확인. 다른 계정이면 로그인 계정 전환 후 다시 확인.

## 2) 현재 저장소 가져오기

원하는 상위 폴더에서 실행. 같은 이름의 폴더가 이미 있으면 다른 빈 위치에서 진행.

```text
gh repo clone bangkh/JavaSE_Project
cd JavaSE_Project
git remote -v
git status
```

origin이 bangkh/JavaSE_Project인지 확인.
기존 ZIP 폴더에서 git init을 반복하기보다 원격 저장소를 clone해서 작업하면 기존 이력과 연결됨.

## 3) 작성자 설정

아래 값은 본인 것으로 바꿔 입력. 이메일은 GitHub에서 확인한 주소 또는 GitHub 제공 noreply 주소 사용.
```text
git config user.name "방경호"
git config user.email "본인의 GitHub 커밋 이메일"
```
위 이메일 설명 문구 자체를 그대로 설정하지 않기.

## 4) 실제 수정·커밋·Push

예: docs/03-setup.md의 체크리스트 중 직접 확인한 항목만 [x]로 수정한 뒤:
```text
git diff
git add docs/03-setup.md
git diff --cached
git commit -m "개발환경 확인 항목 기록"
git push origin main
```

수정한 다른 소스가 있으면 git add 뒤에 해당 파일 경로를 지정.
out이나 토큰 파일을 추가하지 않기. 변경이 없으면 새 커밋도 생기지 않음.
원격에 다른 변경이 생겨 push가 거부되면 git pull --rebase origin main으로 먼저 가져오고, 충돌이 있으면 해결 후 push. 강제 push는 사용하지 않음.

## 5) 확인
```text
git status
git log -1 --oneline
gh repo view bangkh/JavaSE_Project --web
```
웹에서 방금 커밋과 수정 파일이 보이는지 확인.

## 새 저장소 생성 연습이 별도로 필요한 경우

현재 프로젝트에서 실행하지 말고, 별도 새 폴더에서 파일을 만든 뒤 사용.
이름이 겹치지 않는 JavaSE_Practice 예:
```text
git init -b main
git add README.md
git commit -m "Java 실습 시작"
gh repo create bangkh/JavaSE_Practice --private --source=. --remote=origin --push
```
먼저 README.md를 직접 생성하고 작성자 설정도 확인해야 함. 공개 제출이 필요하면 생성 시 공개 여부를 별도로 선택.

참고: https://cli.github.com/manual/gh_auth_login
