package com.suda.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suda.backend.dto.list.ListData;
import com.suda.backend.dto.list.ListResponse;
import com.suda.backend.service.PostService;

@RestController
public class MainController {
    
    @Autowired
    PostService postService;


    @PostMapping("/list")
    public ListResponse list(HttpServletRequest request){
        String key2 = request.getHeader("postGreKey");
 
        System.out.println("키 ? : " + key2);
        if("test".equals(key2)){
            ListResponse list = postService.list();
           return list;
        } 
        return null;
    }

    @PostMapping("/insert")
    public int insert(@RequestBody ListData listData){
        System.out.println("########## Param : " + listData);
        postService.insert(listData);
        return 1;
    }

    @PostMapping("/update")
    public int update(@RequestBody ListData listData){
        System.out.println("########## Param : " + listData);
        postService.update(listData);
        return 1;
    }

    @PostMapping("/delete")
    public int delete(@RequestBody ListData listData){
        System.out.println("########## Param : " + listData);
        postService.delete(listData);
        return 1;
    }
}
