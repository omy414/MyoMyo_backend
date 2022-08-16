package com.suda.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suda.backend.dto.list.ListData;
import com.suda.backend.dto.list.ListResponse;
import com.suda.backend.repository.PostTestRepo;


@Service
public class PostService {

    @Autowired
    PostTestRepo repo;

    
    public ListResponse list() {
        ListResponse result = new ListResponse();
        
        
        result.setList(repo.list());
        return result;
    }

    public int update(ListData listData) {
        repo.update(listData);
        return 1;
    }

    public int insert(ListData listData){
        repo.insert(listData);
        return 1;
    }

    public int delete(ListData listData){
        repo.delete(listData);
        return 1;
    }

}
