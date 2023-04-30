package com.sangmin.bts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/hello")
    public String hello(){
        return "BTS 프로젝트에 오신걸 환영합니다";
    }
}
