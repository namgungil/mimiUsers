package com.example.mimi.il.Service;

import com.example.mimi.il.dto.UserDTO;
import com.example.mimi.il.dto.UserDeleteDTO;
import com.example.mimi.il.dto.UserInsertReqDTO;
import com.example.mimi.il.dto.UserResponseDTO;
import com.example.mimi.il.entity.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    UserResponseDTO login(UserResponseDTO dto);

    public void insert(UserInsertReqDTO insertReqDTO);

    public Optional<User> findById(String userId);

    public List<User> findAll();

    public void update(UserDTO dto);

    public void delete(UserDeleteDTO dto);
}
