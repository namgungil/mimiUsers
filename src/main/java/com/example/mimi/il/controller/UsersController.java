package com.example.mimi.il.controller;

import com.example.mimi.il.Service.UsersService;
import com.example.mimi.il.UserDTO;
import com.example.mimi.il.UserDeleteDTO;
import com.example.mimi.il.entity.UsersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody UsersEntity userE) {
        UsersEntity user = new UsersEntity(userE.getUserName(), userE.getEmail(), userE.getPassword(), userE.getPhoneNum());
        service.insert(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/findbyid")
    public ResponseEntity<UsersEntity> findById(@RequestBody String userId) {
        UsersEntity user = service.findById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        List<UsersEntity> equipmentList = service.findAll();
        return ResponseEntity.ok(equipmentList);
    }

    @PostMapping("/update")
    public void update(@RequestBody UserDTO dto ){
        service.update(dto);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody UserDeleteDTO dto) {
        service.delete(dto);
    }



/*
    @PostMapping("/delete")
    public void delete(@RequestParam Long mgmNum) {
        EquipmentEntity equipment= equipmentService.findByMgmNum(mgmNum);
        equipmentService.delete(mgmNum);

    }*/


}
