package com.example.computeservice1.controller;

import com.example.computeservice1.controller.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 模拟SSO，通过token获取用户信息
     * @param token
     * @return
     */
    @GetMapping(value = "/api/tokenapi/GetUser")
    @ResponseBody
    public UserDTO getUser(@RequestParam("token") String token) {
        UserDTO userDTO = new UserDTO();
        userDTO.setToken(token);
        userDTO.setPassWord("123456");
        userDTO.setIsExpired(false);
        userDTO.setUserCode("misa");
        return userDTO;
    }
}
