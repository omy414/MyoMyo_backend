package com.suda.backend.dto.main.del;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "procResponse", description = "메인 리스트 삭제 응답 데이터")
@Getter
@Setter
public class DeleResponse {
    
    @Schema(description = "메인 리스트 시퀀스 번호", defaultValue = "", allowableValues = {}, example = "3")
    private int seq;
}
