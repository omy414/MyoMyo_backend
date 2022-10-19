# MyoMyoProject

  ## 개인프로젝트입니다.
  ------------------
  ### 프로젝트 제작이유
  특별히 어떤 용도로 서비스를 만들어야겠다~ 라는 생각으로 만든 것은 아닙니다.
  몇 년간 프로젝트를 해오면서 익혔던 기술을 토대로, 어떤 프로젝트로든 발전이 가능한 기반이 되는 프레임워크를 하나 만들고 싶었습니다.
  그래서 공통이 되는 모듈만을 개발하는데 초점이 맞춰져있습니다.

  ### 개발환경
  + java 1.8
  + springBoot 2.7
  + postgresql 12.9
  + hikariCP
  + react
  + ec2
  + s3
  + codeCommit , git
  + gradle
  + mybatis
  + docker
  + jenkins
  + swagger
  
  ### 프로젝트 특징
  back 과 front 가 분리되어있으며 각각 따로 git 에 올라가 있습니다.
  back 은 java 와 springboot 를 활용하였습니다.
  back 은 오직 rest api 통신만을 하고있습니다.
  DB 는 리드레플리카 적용으로 select , insert 를 분리하고있습니다.
  front 는 react 를 활용 비동기 통신은 axios 를 사용하고 있습니다.
  front 에서 swagger 를 통해 api 문서 및 테스트를 진행 할 수 있습니다.
  형상관리는 git 과 codecommit 두 곳을 사용하고 있습니다.
  배포는 jenkins 를 통해 gradle 빌드하여 docker 로 이미지화 해서 올리고 있습니다.
  ec2 에 현재 배포되어있으며 http://43.200.47.199:8080/swagger-ui/index.html 를 통해 접근이 가능합니다.

  ### 현재까지 적용된 공통 모듈 ( Back_end )
  1. Spring MVC 구조의 디렉토리 구성
  2. CROS filter 구성
  3. Lombok을 통한 dto 구성
  4. logBack 으로 로그 수집
  5. yml을 통한 property 설정
  6. gradle 을 통한 빌드
  7. docker 를 통한 이미지
  8. Read Replica 적용
  9. interceptor 적용
  10. hikariCP를 통한 JDBC Connection 구성
  11. swagger 적용
  12. 기본 CRUD 적용

  ### 현재까지 적용된 공통 모듈 ( Front_end )
  1. react 적용
  2. 개발에 용의하도록 분류에 따라 디렉토리 구성
  3. common.js 분리
  4. axios 공통 모듈화
  5. .env를 통한 property 관리
  6. SPA 구성을 위해 react-router-dom 적용
  7. styled-components 적용

 ### 제작과정은 개인 블로그에 있습니다. https://dev-my.tistory.com/
