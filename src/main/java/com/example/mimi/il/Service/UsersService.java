package com.example.mimi.il.Service;

import com.example.mimi.il.UserDTO;
import com.example.mimi.il.UserDeleteDTO;
import com.example.mimi.il.dao.UserDAO;
import com.example.mimi.il.entity.UsersEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersService {
    private final UserDAO dao;


    public void insert(UsersEntity userE) {
        dao.insert(userE);
    }

    public UsersEntity findById(String userId) {
        return dao.findById(Long.valueOf(userId));
    }

    public List<UsersEntity> findAll() {
        return dao.findAll();
    }

    public void update(UserDTO dto) {
        dao.update(dto);
    }

    public void delete(UserDeleteDTO dto) {
        dao.delete(dto);


    }

}
