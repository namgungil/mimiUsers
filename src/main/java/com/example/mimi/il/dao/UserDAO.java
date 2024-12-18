package com.example.mimi.il.dao;

import com.example.mimi.il.entity.UsersEntity;

import java.util.List;

public interface UserDAO {
    // 생성
    void insert(UsersEntity dto);
    // 검색
    UsersEntity findById(String userId);
    // 전체검색
    List<UsersEntity> findAll();
    // 수정
    void update(UsersEntity dto);
    // 관리자 권한 수정
    void adminUpdate(UsersEntity dto);
    // 삭제
    void delete(String userId);

}
