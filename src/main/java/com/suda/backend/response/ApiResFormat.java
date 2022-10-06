package com.suda.backend.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @apiNote 요청에 대한 공통 응답 포맷
 * @version 1.0
 * @author Dratini
 * @since 2022.10.05
 */
@Schema(name = "ApiResFormat", description = "Api Response Format")
@Getter
@Setter
public class ApiResFormat<T> {

    @Schema(description = "요청결과 상태", nullable = false, example = "success")
    private String result_status;
    @Schema(description = "요청결과 코드", nullable = false, example = "200")
    private int result_code;
    @Schema(description = "요청결과 메세지", nullable = false, example = "요청에 성공하였습니다.")
    private String result_message;
    @Schema(description = "요청결과 데이터", nullable = false)
    private T result;

    public ApiResFormat() {
    }

    public ApiResFormat(String status, int resultCode, String resultMessage, T resultObj) {
        this.result_status = status;
        this.result_code = resultCode;
        this.result_message = resultMessage;
        this.result = resultObj;
    }

    public ApiResFormat(int resultCode, T resultObj) {
        this.result_status = "success";
        this.result_code = resultCode;
        this.result_message = "요청에 성공하였습니다.";
        this.result = resultObj;
    }

    public ApiResFormat(int resultCode, String resultMessage, T resultObj) {
        this.result_status = "success";
        this.result_code = resultCode;
        this.result_message = resultMessage;
        this.result = resultObj;
    }

    public ApiResFormat(String resultMessage, T resultObj) {
        this.result_status = "success";
        this.result_code = 200;
        this.result_message = resultMessage;
        this.result = resultObj;
    }

    public ApiResFormat(T resultObj) {
        this.result_status = "success";
        this.result_code = 200;
        this.result_message = "요청에 성공하였습니다.";
        this.result = resultObj;
    }
}
