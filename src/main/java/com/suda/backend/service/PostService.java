package com.suda.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suda.backend.dto.main.del.DeleParam;
import com.suda.backend.dto.main.del.DeleResponse;
import com.suda.backend.dto.main.list.ListData;
import com.suda.backend.dto.main.proc.ProcParam;
import com.suda.backend.dto.main.proc.ProcResponse;
import com.suda.backend.dto.main.list.ListResponse;
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

    public ProcResponse update(ProcParam procParam) {
        ProcResponse result = new ProcResponse();
        repo.update(procParam);
        result.setSeq(procParam.getSeq()); 
        return result;
    }

    public ProcResponse insert(ProcParam procParam){
        ProcResponse result = new ProcResponse();
        repo.insert(procParam);
        result.setSeq(procParam.getSeq()); 
        return result;
    }

    public DeleResponse delete(DeleParam deleParam){
        DeleResponse result = new DeleResponse();
        int aa = repo.delete(deleParam);
        System.out.println("뭐가나오냐냐냥 : " + aa);
        result.setSeq(aa);
        return result;
    }

}
