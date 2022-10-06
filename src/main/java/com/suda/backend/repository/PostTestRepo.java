package com.suda.backend.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.suda.backend.dto.main.list.ListData;
import com.suda.backend.dto.main.proc.ProcParam;
import com.suda.backend.dto.main.del.DeleParam;

@Repository
public interface PostTestRepo {

    public List<ListData> list();

    public int insert(ProcParam ProcParam);

    public int delete(DeleParam deleParam);

    public int update(ProcParam procParam);
}
