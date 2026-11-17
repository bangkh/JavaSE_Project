# 3. 개발환경 설치

설치는 개인 PC에서 진행. 아래 체크는 실행 후 직접 확인할 항목이며 완료 기록이 아님.
학교에서 별도 설치 파일이나 버전을 제공했다면 그 버전을 우선 적용.

## 다운로드

| 프로그램 | 공식 경로 | 용도 |
| --- | --- | --- |
| JDK 8 | https://adoptium.net/temurin/releases/?version=8 | Java 컴파일·실행 |
| MariaDB | https://mariadb.org/download/ | 데이터베이스 |
| STS / Spring Tools | https://spring.io/tools/ | Eclipse 기반 Spring 개발 도구 |
| IntelliJ IDEA | https://www.jetbrains.com/idea/download/ | Java IDE |
| Postman | https://www.postman.com/downloads/ | HTTP API 요청 확인 |
| Git | https://git-scm.com/downloads | 버전 관리 |
| GitHub CLI | https://cli.github.com/ | GitHub 인증·저장소 작업 |

STS와 IntelliJ는 둘 중 수업에서 사용하는 IDE부터 설정해도 됨.
IDE를 실행하는 Java와 프로젝트를 컴파일하는 JDK는 별개. 최신 IDE 실행용 runtime을 JDK 8로 억지로 바꾸지 말고, **프로젝트 SDK만 8**로 지정.

## Windows

1. JDK 다운로드에서 버전 8, JDK, Windows, PC에 맞는 아키텍처 선택. 일반 Intel/AMD PC는 x64.
2. MSI 설치 시 PATH와 JAVA_HOME 설정 옵션이 있으면 적용. 없으면 환경변수 편집에서 JAVA_HOME을 실제 JDK 폴더로, Path에 %JAVA_HOME%\bin 추가.
3. 새 PowerShell을 열어 확인.
```powershell
java -version
javac -version
where.exe java
where.exe javac
```
둘 다 1.8이어야 함. 여러 경로가 나오면 PATH 순서와 JAVA_HOME 확인.

4. MariaDB MSI 설치. 수업 버전을 선택하고 root 비밀번호를 직접 설정. 서비스로 실행하고 포트 확인(일반적으로 3306).
5. MariaDB 클라이언트가 있는 터미널에서 실행.
```text
mariadb -u root -p
SELECT VERSION();
exit;
```
명령을 찾지 못하면 설치 폴더의 bin에서 실행하거나 해당 폴더를 PATH에 추가.
6. IntelliJ 설치 후 프로젝트 폴더 Open → Project Structure → Project SDK 8, Language level 8 → src를 Sources Root로 설정.
7. STS 사용 시 Windows 배포판 설치·실행 → Preferences → Java → Installed JREs에 JDK 8 추가 → Java Project 생성/가져오기 → 프로젝트 JRE 및 Compiler compliance level 1.8 지정.
8. Postman Windows 설치 파일 실행 → 앱 실행 확인. 이 프로젝트는 HTTP 서버가 아니므로 localhost:8080 API는 아직 없음.
9. Git과 GitHub CLI 설치 후 새 터미널에서 git --version, gh --version 확인.

## Mac

1. Apple 메뉴의 '이 Mac에 관하여'에서 Intel / Apple Silicon 구분.
2. 공식 배포처에서 JDK 8의 macOS 및 CPU에 맞는 패키지를 선택해 설치. 해당 조합이 없으면 임의로 다른 CPU 패키지를 설치하지 말고 수업 제공 배포판 확인.
3. 터미널에서 확인 및 현재 세션의 JDK 선택.
```bash
/usr/libexec/java_home -V
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
export PATH="$JAVA_HOME/bin:$PATH"
java -version
javac -version
```
명령 성공 후 같은 설정을 ~/.zshrc에 추가하면 새 터미널에도 적용됨.

4. Homebrew가 없다면 https://brew.sh 안내로 설치. 수업에서 MariaDB 버전을 지정하지 않았다면:
```bash
brew install mariadb
brew services start mariadb
mariadb
```
수업이 특정 버전을 지정하면 해당 버전 설치법을 먼저 확인. 로그인 방식은 초기 계정 설정에 따라 다르며 root 비밀번호를 설정한 환경은 mariadb -u root -p 사용.
접속 후 SELECT VERSION(); 실행, exit;로 종료.
5. IntelliJ의 Mac/CPU에 맞는 DMG를 받아 Applications로 이동 → 프로젝트 Open → SDK 8과 language level 8 지정.
6. STS도 Mac/CPU에 맞는 배포판 선택 → 실행 → Preferences의 Installed JREs와 프로젝트 JRE를 JDK 8로 설정.
7. Postman도 Intel/Apple Silicon에 맞게 설치 후 실행.
8. Homebrew로 CLI 설치:
```bash
brew install git gh
git --version
gh --version
```

## 이번 Java 실습 컴파일

Windows:
```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\build.ps1
```
Mac:
```bash
bash build.sh
```

두 스크립트 모두 JDK 8의 javac인지 검사하고 src/lesson만 컴파일.
JDK 8을 못 찾으면 PATH 또는 JAVA_HOME을 고친 후 재실행.
MariaDB와 Postman은 이후 서버 수업 준비물로, 이번 main 예제 실행에는 필요 없음.

## 직접 확인
- [ ] java와 javac 모두 1.8
- [ ] IDE의 프로젝트 SDK도 8
- [ ] MariaDB에서 SELECT VERSION() 결과 확인
- [ ] Postman 앱 실행
- [ ] git / gh 버전 확인
- [ ] build 실행 후 out/lesson 생성

공식 설치·설정 참고:
- https://adoptium.net/installation/
- https://mariadb.com/docs/server/mariadb-quickstart-guides/installing-mariadb-server-guide
- https://mariadb.com/get-started-with-mariadb/
- https://www.jetbrains.com/help/idea/sdk.html
- https://learning.postman.com/docs/getting-started/installation/install-app/
