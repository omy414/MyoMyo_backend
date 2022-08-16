package com.suda.backend.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.suda.backend.dto.list.ListData;

@Repository
public interface PostTestRepo {

    public List<ListData> list();

    public int insert(ListData listData);

    public int delete(ListData listData);

    public int update(ListData listData);
}
