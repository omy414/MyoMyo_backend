package com.suda.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suda.backend.dto.main.del.DeleParam;
import com.suda.backend.dto.main.del.DeleResponse;
import com.suda.backend.dto.main.list.ListData;
import com.suda.backend.dto.main.list.ListParam;
import com.suda.backend.dto.main.proc.ProcParam;
import com.suda.backend.dto.main.proc.ProcResponse;
import com.suda.backend.dto.main.list.ListResponse;
import com.suda.backend.response.ApiResErrFormat;
import com.suda.backend.response.ApiResFormat;
import com.suda.backend.response.ApiResNoAuthFormat;
import com.suda.backend.service.PostService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "main", description = "메인화면 리스트 API")
@RequestMapping("/main")
@RestController
public class MainController {
    
    @Autowired
    PostService postService;

    @Tag(name = "main")
    @ApiOperation(value = "메인화면 리스트 조회", notes = "메인화면의 리스트를 조회하여 가져온다.", authorizations = {
            @Authorization(value = "apiKey") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메인화면 리스트 조회 성공", content = @Content(schema = @Schema(implementation = ApiResFormat.class))),
            @ApiResponse(responseCode = "201", description = "500과 동일"),
            @ApiResponse(responseCode = "401", description = "권한 없음(키누락)", content = @Content(schema = @Schema(implementation = ApiResNoAuthFormat.class))),
            @ApiResponse(responseCode = "403", description = "500과 동일"),
            @ApiResponse(responseCode = "404", description = "500과 동일"),
            @ApiResponse(responseCode = "500", description = "요청 실패", content = @Content(schema = @Schema(implementation = ApiResErrFormat.class)))
    })
    @PostMapping(value = "/list" , produces = "application/json")
    public ResponseEntity<ApiResFormat<ListResponse>> list(HttpServletRequest request, @RequestBody ListParam param){
        System.out.println("무슨값 : " + param);
        ListResponse list = postService.list();

        return  new ResponseEntity<ApiResFormat<ListResponse>>(new ApiResFormat<ListResponse>(list), HttpStatus.OK);
    }

    @Tag(name = "main")
    @ApiOperation(value = "메인화면 리스트 등록", notes = "메인화면의 리스트에 등록한다.", authorizations = {
            @Authorization(value = "apiKey") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메인화면 리스트 등록 성공", content = @Content(schema = @Schema(implementation = ApiResFormat.class))),
            @ApiResponse(responseCode = "201", description = "500과 동일"),
            @ApiResponse(responseCode = "401", description = "권한 없음(키누락)", content = @Content(schema = @Schema(implementation = ApiResNoAuthFormat.class))),
            @ApiResponse(responseCode = "403", description = "500과 동일"),
            @ApiResponse(responseCode = "404", description = "500과 동일"),
            @ApiResponse(responseCode = "500", description = "요청 실패", content = @Content(schema = @Schema(implementation = ApiResErrFormat.class)))
    })
    @PostMapping("/insert")
    public ResponseEntity<ApiResFormat<ProcResponse>> insert(@RequestBody ProcParam ProcParam){
        System.out.println("########## Param : " + ProcParam);
        
        return new ResponseEntity<ApiResFormat<ProcResponse>>(new ApiResFormat<ProcResponse>(postService.insert(ProcParam)),
                                HttpStatus.OK);
    }

    @Tag(name = "main")
    @ApiOperation(value = "메인화면 리스트 수정", notes = "메인화면의 리스트의 내용을 수정한다.", authorizations = {
            @Authorization(value = "apiKey") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메인화면 리스트 수정 성공", content = @Content(schema = @Schema(implementation = ApiResFormat.class))),
            @ApiResponse(responseCode = "201", description = "500과 동일"),
            @ApiResponse(responseCode = "401", description = "권한 없음(키누락)", content = @Content(schema = @Schema(implementation = ApiResNoAuthFormat.class))),
            @ApiResponse(responseCode = "403", description = "500과 동일"),
            @ApiResponse(responseCode = "404", description = "500과 동일"),
            @ApiResponse(responseCode = "500", description = "요청 실패", content = @Content(schema = @Schema(implementation = ApiResErrFormat.class)))
    })
    @PostMapping("/update")
    public ResponseEntity<ApiResFormat<ProcResponse>> update(@RequestBody ProcParam ProcParam){
        System.out.println("########## Param : " + ProcParam);
        
        return new ResponseEntity<ApiResFormat<ProcResponse>>(new ApiResFormat<ProcResponse>(postService.update(ProcParam)),
                                HttpStatus.OK);
    }

    @Tag(name = "main")
    @ApiOperation(value = "메인화면 리스트 삭제", notes = "메인화면의 리스트에 선택 값을 삭제한다.", authorizations = {
            @Authorization(value = "apiKey") })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "메인화면 리스트 삭제 성공", content = @Content(schema = @Schema(implementation = ApiResFormat.class))),
            @ApiResponse(responseCode = "201", description = "500과 동일"),
            @ApiResponse(responseCode = "401", description = "권한 없음(키누락)", content = @Content(schema = @Schema(implementation = ApiResNoAuthFormat.class))),
            @ApiResponse(responseCode = "403", description = "500과 동일"),
            @ApiResponse(responseCode = "404", description = "500과 동일"),
            @ApiResponse(responseCode = "500", description = "요청 실패", content = @Content(schema = @Schema(implementation = ApiResErrFormat.class)))
    })
    @PostMapping("/delete")
    public ResponseEntity<ApiResFormat<DeleResponse>> delete(@RequestBody DeleParam deleParam){
        System.out.println("########## Param : " + deleParam);
        
        return new ResponseEntity<ApiResFormat<DeleResponse>>(new ApiResFormat<DeleResponse>(postService.delete(deleParam)),
        HttpStatus.OK);
    }
}
