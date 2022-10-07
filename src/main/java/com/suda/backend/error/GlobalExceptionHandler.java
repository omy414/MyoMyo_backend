package com.suda.backend.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.suda.backend.response.ApiResFormat;

/**
 * @apiNote GlobalExceptionHandler -> 실제 서비스에서 예외처리 될 시 핸들링(공통 포맷)
 * @version 1.0
 * @author Dratini
 * @since 2020.10.07
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResFormat> globalException(Exception ex) {
        return new ResponseEntity<ApiResFormat>(new ApiResFormat("fail", 500, "요청에 실패하였습니다.", null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
