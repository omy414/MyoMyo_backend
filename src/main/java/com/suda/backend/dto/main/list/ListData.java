package com.suda.backend.dto.main.list;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListData {
    private int seq;
    @Schema(description = "이름", defaultValue = "", allowableValues = {}, example = "30")
    private String name;
    private String pw;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private String date;
}
