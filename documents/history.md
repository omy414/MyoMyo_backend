# 2022.08.16

backEnd , frontEnd 분리하여 기본 프로젝트생성 

1. backEnd
``` 기본적으로 backend 는 restAPI 구조로 apiKey 를 받아 데이터를 뿌려주거나 처리하는 기능만 담당하게 구성됨```
``` property 는 yml 를 활용 ```
``` 추후에 swagger 추가 등으로 api 관리에 용의하게 만들거나 ```
``` HashMap custom 을 통한 dto 공통 처리 방식으로 갈지는 생각해봐야함 (해당 방식 사용시 개발은 편해지나 swagger      사용    어려움```
- 자바1.8
- Spring boot 2.7.2
- gradle 7.5
- logback

2. frontEnd
``` frontEnd 는  react 로 구성함 axios 를 통해 backend 와 통신하여 자료를 가져오도록 구성됨 ```
``` property 는 .env 에 담아두고 사용 해당 위치에서 apiKey 등을 활용 ```
``` 완전하게 분리되어 있어서 데이터를 가져오지 못하더라도 화면자체에서 문제를 일으키지는 않음 ```
- react
- node

3. db
``` DB 는 무료로 사용할 수 있는 것 중에 성능이 젤 좋은 postgreSql로 구성함 ```
- postgreSql 14.1

4. 형상관리
``` git 으로 기본 형상은 구현했으나 aws 의 code_commit 을 활용할 예정```

5. nas
``` aws의 s3 를 활용 ```

6. 서버
``` aws 의 ec2 클라우드 서버```

7. 배포방식
``` backend 폴더에있는 dockerFile 에 설정을 추가로 넣어 front 와 back을 하나의 war 로 말아서 image 화 시킴```
``` 해당 이미지를 pipeLine 으로 무중단 배포 계획 ``` 
``` docker jib 나 jenkins 등의 활용 등에 대해서도 연구가 필요 ```









