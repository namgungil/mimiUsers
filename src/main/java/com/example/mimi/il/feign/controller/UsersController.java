package com.example.mimi.il.feign.controller;

import com.example.mimi.il.feign.Service.UsersService;
import com.example.mimi.il.entity.UsersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/insert")
    public UsersEntity insert() {
        return usersService.insert(new UsersEntity("일", "il@naver.com","5555", "01033334444"));
    }




}
