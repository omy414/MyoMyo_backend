package com.suda.backend.dto.main.del;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "deleParameter", description = "메인 리스트 데이터 삭제 파라미터")
@Getter
@Setter
public class DeleParam {
    private int seq;
}
