package com.suda.backend.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @apiNote 해당 클래스는 실제로는 사용하지 않고, Swagger 작성용으로 만들어졌습니다.
 * @author Dratini
 * @since 2022.10.05
 * @version 1.0
 */
@Schema(name = "ApiResErrFormat", description = "")
@Getter
@Setter
public class ApiResErrFormat {
    @Schema(description = "요청결과 상태", nullable = false, example = "fail")
    private String result_status;
    @Schema(description = "요청결과 코드", nullable = false, example = "500")
    private int result_code;
    @Schema(description = "요청결과 메세지", nullable = false, example = "요청에 실패하였습니다.")
    private String result_message;
    @Schema(description = "요청결과 데이터", nullable = true, example = "null")
    private String result;

}
