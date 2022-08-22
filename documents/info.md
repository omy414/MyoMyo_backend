
# 구동 조건
  1.docker 가 설치되어있어야 한다 ( 윈도우의 경우 docker 데스크탑 설치)
  2.jdk1.8이 설치되어있어야한다.


# 구동 방법 DB
 1. postgres 설치 ( terminal 에서 아래 명령어 실행)
    - docker pull postgres 
 2. docker images 로 postgres 이미지 생성 되었는지 확인
 3. postgres 구동
    - docker run -d -p 5432:5432 -e POSTGRES_PASSWORD="YourPw" --name PostgreSQL01 postgres
    (1)name 으로 이름을 정하고
    (2)password 에 원하는 암호를 넣고
    (3) -p 5432:5432 로 port 번호를 정하고
    (4) -d postgres 로 postgres 백그라운드 실행

  4. docker ps -a 로 컨테이너 상태 확인 가능
  5. dbeaver 등으로 위의 정보대로 제대로 db 붙을수 있는지 체크

# 구동 방법 WAS ( backend )
  1. 원하는 경로로 backend 소스를 git clone 해온다.
    git clone https://github.com/omy414/MyoMyo_backend.git [dir]  (*dir 부분은 안넣으면 현재 위치에 넣음)
  2. clone 해온 경로 최상단 dockerFile 과 gradlew 있는 곳으로 이동 ex) cd
  2. ./gradlew  명령어로 init
  3. ./gradlew clean 명령어로 정리
  4. ./gradlew build 로 gradlew 빌드
  5. 폴더내에 있는 아무 콘트롤러 ide 에서 더블클릭으로 내용물 확인 
     ( springboot 시스템이 controller 를 인식해야 구동버튼이생김)
  6. springboot 실행

# 구동 방법 WEB ( frontend )
  1. 원하는 경로로 frontend 소스를 git clone 해온다.
     git clone https://github.com/omy414/MyoMyo_frontend.git [dir] (*dir 부분은 안넣으면 현재 위치에 넣음)
  2. clone 해온 경로 최상단 으로 이동
  3. npm -v 로 npm 설치 여부 확인 ( 미 설치시 원하는버전 아무거나 찾아서 받기 )
  4. npm start 로 구동   









