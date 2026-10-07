package kr.ac.jbnu.ath.practice1.controller;

import kr.ac.jbnu.ath.practice1.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    // ------------------- get (조회) -------------------

    // 1. get 정상 조회 (200 ok)
    @GetMapping("/normal")
    public ResponseEntity<ApiResponse<String>> getNormalData() {
        ApiResponse<String> response = new ApiResponse<>("success", "데이터 조회 성공");
        return ResponseEntity.status(HttpStatus.OK).body(response); // 200 반환
    }

    // 2. get 없는 데이터 조회 (404 not found)
    @GetMapping("/notfound")
    public ResponseEntity<ApiResponse<String>> getNotFoundData() {
        ApiResponse<String> response = new ApiResponse<>("error", "데이터를 찾을 수 없습니다.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // 404 반환
    }

    // ------------------- post (생성) -------------------

    // 3. post 정상 생성 (201 created)
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> createData() {
        ApiResponse<String> response = new ApiResponse<>("success", "데이터 생성 성공");
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201 반환
    }

    // 4. post 잘못된 요청 (400 bad request)
    @PostMapping("/badrequest")
    public ResponseEntity<ApiResponse<String>> createBadRequest() {
        ApiResponse<String> response = new ApiResponse<>("error", "필수 파라미터가 누락되었습니다.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // 400 반환
    }

    // ------------------- put (수정) -------------------

    // 5. put 정상 수정 (200 OK)
    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateData() {
        ApiResponse<String> response = new ApiResponse<>("success", "데이터 수정 완료");
        return ResponseEntity.status(HttpStatus.OK).body(response); // 200 반환
    }

    // 6. put 서버 에러 발생 (500 internal server error)
    @PutMapping("/error")
    public ResponseEntity<ApiResponse<String>> updateServerError() {
        ApiResponse<String> response = new ApiResponse<>("error", "서버 내부에서 오류가 발생했습니다.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // 500 반환
    }

    // ------------------- delete (삭제) -------------------

    // 7. delete 정상 삭제 (200 OK)
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<String>> deleteData() {
        ApiResponse<String> response = new ApiResponse<>("success", "데이터 삭제 완료");
        return ResponseEntity.status(HttpStatus.OK).body(response); // 200 반환
    }

    // 8. delete 서비스 이용 불가 (503 service unavailable)
    @DeleteMapping("/maintenance")
    public ResponseEntity<ApiResponse<String>> deleteMaintenance() {
        ApiResponse<String> response = new ApiResponse<>("error", "현재 서버 점검 중으로 삭제 불가");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response); // 503 반환
    }
}