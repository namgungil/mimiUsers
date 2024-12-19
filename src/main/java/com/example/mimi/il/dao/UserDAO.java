package com.example.mimi.il.dao;

import com.example.mimi.il.UserDTO;
import com.example.mimi.il.UserDeleteDTO;
import com.example.mimi.il.entity.UsersEntity;

import java.util.List;

public interface UserDAO {
    // 생성
    void insert(UsersEntity dto);
    // 검색
    UsersEntity findById(Long userId);
    // 전체검색
    List<UsersEntity> findAll();
    // 수정
    void update(UserDTO dto);
    // 관리자 권한 수정
    void adminUpdate(UsersEntity dto);
    // 삭제
    void delete(UserDeleteDTO dto);

}
