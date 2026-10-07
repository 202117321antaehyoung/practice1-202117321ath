# CRUD 백엔드 만들기
### 202117321 안태형 (웹서비스설계 2분반)

1. Spring Boot를 이용해 기본적인 RESTful API를 구현.
2. 클라이언트의 요청 기록을 남기는 미들웨어(Interceptor)를 적용.

## 개발 환경
- **언어 및 프레임워크:** Java, Spring Boot
- **개발 도구 (IDE):** IntelliJ IDEA
- **API 테스트:** Postman

---

## 코드 내용

### 1. HTTP 메소드별 API 구현 및 상태 코드 분배 (A, C)
GET, POST, PUT, DELETE 4가지 메소드를 각각 2개씩, 총 8개의 API 엔드포인트 제작. 
과제 조건에 맞춰 2xx, 4xx, 5xx 상태 코드도 상황에 맞게 반환.

- **GET (데이터 조회)**
    - /api/assignment/normal ➔ 데이터 정상 조회 (200 OK)
    - /api/assignment/notfound ➔ 없는 데이터 조회 시도 (404 Not Found)
- **POST (데이터 생성)**
    - /api/assignment/create ➔ 새로운 데이터 생성 완료 (201 Created)
    - /api/assignment/badrequest ➔ 필수 파라미터 누락 등 잘못된 요청 (400 Bad Request)
- **PUT (데이터 수정)**
    - /api/assignment/update ➔ 기존 데이터 수정 완료 (200 OK)
    - /api/assignment/error ➔ 서버 내부 로직 오류 발생 (500 Internal Server Error)
- **DELETE (데이터 삭제)**
    - /api/assignment/delete ➔ 데이터 정상 삭제 (200 OK)
    - /api/assignment/maintenance ➔ 서버 점검으로 인한 삭제 서비스 불가 (503 Service Unavailable)

### 2. 미들웨어 로깅 구현 (B)
어떤 API가 호출되었는지 서버 측에서 직관적으로 파악할 수 있도록 HandlerInterceptor를 상속받은 LoggingInterceptor를 구현.
요청이 들어올 때마다 서버 콘솔 창에 [Request Log] Method: GET | URI: /api/assignment/normal과 같이 사용된 HTTP 메소드와 주소가 출력되도록 세팅.

### 3. 응답 포맷 통일 (D)
제네릭(Generic)을 활용한 ApiResponse<T> 클래스 생성. 이를 통해 정상 응답이든 에러 응답이든 상관없이 모든 API가 아래처럼 통일된 JSON 구조로 결과를 반환.

```json
{
  "status": "success",
  "data": "데이터 조회 성공"
}