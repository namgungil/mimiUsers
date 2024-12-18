package com.example.mimi.il.feign.Service;

import com.example.mimi.il.dao.UserDAOImpl;
import com.example.mimi.il.entity.UsersEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "user", url = "http://127.0.0.1:5677")
public interface UsersService {

    @GetMapping("/rental/insert")
    public UsersEntity insert(UsersEntity user);

    @GetMapping()
    public List<UsersEntity> getAll();


}
