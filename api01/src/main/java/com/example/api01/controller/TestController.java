package com.example.api01.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@SecurityRequirement(name = "Authorization")
@RequestMapping("/api/sample")
@RestController
@Tag(name="ttest",description = "pppap")
public class TestController {

    @Operation(summary = "test hello", description = "hello 샘플 예제입니다. ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK!!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping("/hello")
    public ResponseEntity<String> hello(
            @Parameter(description = "이름", required = true, example = "박소연") @RequestParam String name,
            @Parameter(description = "나이", example = "21") @RequestParam int age
    ) {
        return ResponseEntity.ok("안녕하세요. "+age+"살 "+name+"님");
    }

    @GetMapping("/ok")
    public ResponseEntity<String> okTest() {
        return ResponseEntity.ok("okTest");
    }

    @Operation(summary = "summary",description = "description")
    @GetMapping("/doA")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<String> doA(){
        return Arrays.asList("aaa","bbbb");
    }

    @GetMapping("/doB")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<String> doB(){
        return Arrays.asList("aaa","bbbb","ccccc");
    }
}