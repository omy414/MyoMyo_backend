package com.suda.backend.dto.main.proc;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "procParameter", description = "메인 리스트 데이터 저장 파라미터")
@Getter
@Setter
public class ProcParam {
    private int seq;
    @Schema(description = "이름", defaultValue = "", allowableValues = {}, example = "30")
    private String name;
    private String pw;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private String date;
}
