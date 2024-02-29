# 우리집은 도서관 README.md
## 목차
```
1. Swagger UI 주소
2. h2-console
3. 기술스택
4. 애플리케이션 구동
5. API 상세 설명
```

## Swagger UI 주소
```
1. http://localhost:9090/swagger-ui/index.html
```

## H2-Console 주소 (데이터 확인이 필요할시에 접속합니다.)
```
1. http://localhost:9090/h2-console
```
![h2-console_로그인](https://github.com/gojunghyo/myhome-library/assets/128199051/80aac1e1-39f4-45d2-9a14-e1d63053ef64)


## 기술 스택
```
프레임워크: Spring Boot 2.6.8
언어: Kotlin
RDB: H2
UI: Swagger UI 3.0
빌드도구: Gradle 8.5
```

## 애플리케이션 구동
```
1. git clone https://github.com/gojunghyo/myhome-library.git
2. 인텔리제이실행 -> myhome-libray 실행 -> File -> Project Structure -> SDK 11 (캡쳐화면 참조부탁드립니다.)
3. File -> Settings -> Gradle (캡쳐화면 참조부탁드립니다.)
```
1. ![인텔리제이_프로젝트_자바환경](https://github.com/gojunghyo/myhome-library/assets/128199051/e91ee972-fb47-47c0-ab4f-dab30a459756)
2. ![자바11확인_그래들](https://github.com/gojunghyo/myhome-library/assets/128199051/df2922d7-c7e4-45c9-8e37-f13b463dc9a7)




## 제공되는 API에 대한 상세 설명

1. http://localhost:9090/swagger-ui/index.html 접속합니다.
2. 제공되는 API는 (도서, 도서대여, 도서위탁, 회원) 으로 다음과 같습니다.
3. ![제공되는도서API](https://github.com/gojunghyo/myhome-library/assets/128199051/501fd750-c36c-48eb-a67a-54f96b9efd6b)


### 회원가입 API
1. 다음과 같이 회원가입을 시도합니다. (패스워드, 핸드폰번호를 검증하기에 올바르지 않은 데이터를 넣는다면 회원가입에 실패합니다.)
2. 회원가입 API -> Try it out
3. ![회원가입](https://github.com/gojunghyo/myhome-library/assets/128199051/1312247c-86ac-4dbc-8699-c8ce3f2f3a59)
4. 회원 조회 API (디폴트 회원 두명과 방금 회원가입한 고정효테스트 회원이 등록되어있는것을 확인합니다.)
5. ![전체회원조회시](https://github.com/gojunghyo/myhome-library/assets/128199051/562c7f1e-8ad5-43e9-aa35-e3b1ba1f9c4b)
   

### 도서 API
1. 도서를 다음과 같이 등록합니다.
2. ![도서등록api](https://github.com/gojunghyo/myhome-library/assets/128199051/da624f61-b8c7-4050-91af-3b6eb7322e3a)
3. 동일한 값으로 도서를 등록한다면 다음과 같이 실패합니다.
4. ![이미등록된도서](https://github.com/gojunghyo/myhome-library/assets/128199051/9a31c0f5-75f7-4ccb-b546-623c63821dc5)


### 도서 위탁 API
1. 다음과 같이 도서를 위탁 합니다.
2. ![도서위탁](https://github.com/gojunghyo/myhome-library/assets/128199051/3faa0e1b-d30d-48d4-9081-c24a865fe0ae)


### 도서 대여 API
1. 위에서 위탁한 "나는 행복한 푸바오 할부지입니다" , ISBN "9791171251179" 을 대여 합니다. 위탁한 회원의 핸드폰 번호도 같이 넣어줍니다.
2. ![도서대여실행](https://github.com/gojunghyo/myhome-library/assets/128199051/3135e14d-6800-4f75-8302-1cbaa4992670)
3. 10~20초 사이 (랜덤) 시간동안 대여후 자동 반납이 됩니다.
4. ![응답값_도서대여](https://github.com/gojunghyo/myhome-library/assets/128199051/62854baa-4951-44fb-a057-6fecf0714082)

### [도서 대여 API 예외상황] 대여중인 도서를 다시 대여한다고 하였을때, 반납이후 대여가능 합니다.
1.![응답값_대여중인도서_대여](https://github.com/gojunghyo/myhome-library/assets/128199051/5877cc2a-6ad8-445d-af09-86bf7336fd77)


### 도서 대여 가능 목록 Pagination (cursor 기반)
1. 다음과 같이 실행하였을때 기본정렬값은 rentalCount (대여횟수의 오름차순 입니다)
2. ![도서대여가능목록](https://github.com/gojunghyo/myhome-library/assets/128199051/af027b18-ad0f-414e-8fa4-a7485b53ad1b)
3.![응답값확인](https://github.com/gojunghyo/myhome-library/assets/128199051/10490637-ed79-47bc-9ac6-6dc88639d549)


### 정렬 파라미터
```
[sortField]
rentalCount 대여 카운트
rentalPrice 대여 가격
registrationDate 등록일

[sortOrder]
DESC, ASC
```

### Example 등록일로 도서 대여가능 목록 내림차순 (최근등록일순)
1. 다음과 같이 파라미터를 넣어줍니다.
2. ![등록일순도서대여](https://github.com/gojunghyo/myhome-library/assets/128199051/8460ca42-6fc1-429d-b6cf-d3bbb5d9e144)
3. 응답확인
4. ![등록일순응답확인](https://github.com/gojunghyo/myhome-library/assets/128199051/e611c339-438a-48e6-be15-eb3fb168c955)



## 마무리 하며
```
1. 우선 긴 api 문서를 실행/확인해주셔서 감사합니다.
2. 궁금하신 부분이나 문의사항은 gojgho@naver.com 으로 연락 부탁드립니다.
3. 감사합니다.
```
