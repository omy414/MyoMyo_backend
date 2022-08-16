package com.suda.backend.dto.list;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListResponse {

    private int cnt;
    private List<ListData> list;
}
