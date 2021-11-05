package com.mooc.sb2.controller;

import com.mooc.sb2.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: ludepeng
 * @date: 2021-09-06 11:32
 */
@RestController
@RequestMapping("/event")
public class UserEventController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public String register(String userName) {
        userService.register(userName);
        return "注册成功";
    }
}
