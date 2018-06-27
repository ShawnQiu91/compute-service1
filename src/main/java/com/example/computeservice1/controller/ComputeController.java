package com.example.computeservice1.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
@RefreshScope
public class ComputeController {
    /**
     * 问好
     * @return
     */
    @GetMapping("/v1/hello")
    @ApiOperation(value = "问好", notes = "", produces = "application/json;charset=UTF-8")
    public String hello(){
        return "hello-service1";
    }
}
