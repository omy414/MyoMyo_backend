package com.suda.backend.dto.main.list;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(name = "listParameter", description = "요청 파라미터")
@Getter
@Setter
public class ListParam  {

    @Schema(description = "", defaultValue = "", allowableValues = {}, example = "10", hidden = true)
    private int scpSeq;
    @Schema(description = "페이지 번호", defaultValue = "", allowableValues = {}, example = "1")
    private int pageNo;
    @Schema(description = "총 개수", defaultValue = "", allowableValues = {}, example = "30")
    private int totalCount;
    @Schema(description = "페이지 크기", defaultValue = "", allowableValues = {}, example = "20")
    private int pageSize;

    @Schema(description = "가져올 데이터양", defaultValue = "", allowableValues = {}, example = "10", hidden = true)
    private int offset;

    //@Schema(description = "유지보수 상태값", defaultValue = "", allowableValues = {}, example = "203")
    //private String[] serviceState;
    @Schema(description = "검색어", defaultValue = "", allowableValues = {}, example = "검색어")
    private String searchText;
}
