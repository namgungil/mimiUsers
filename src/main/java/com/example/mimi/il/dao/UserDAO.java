package com.example.mimi.il.dao;

import com.example.mimi.il.dto.UserDTO;
import com.example.mimi.il.dto.UserDeleteDTO;
import com.example.mimi.il.dto.UserRoleDTO;
import com.example.mimi.il.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    // 로그인
    User login(String email, String password);
    // 생성
    void insert(User dto);
    // 검색
    Optional<User> findById(Long userId);
    // 전체검색
    List<User> findAll();
    // 수정
    void update(User user);
    // 관리자 권한 수정
    void adminUpdate(User user);
    // 삭제
    void delete(User user);

}
