package com.example.mimi.il.Service;

import com.example.mimi.il.dto.*;
import com.example.mimi.il.dao.UserDAO;
import com.example.mimi.il.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UserDAO dao;
    private final ModelMapper modelMapper;


    @Override
    public UserResponseDTO login(UserResponseDTO dto) {
        User user =dao.login(dto.getEmail(), dto.getPassword());
        UserResponseDTO logindto = modelMapper.map(user, UserResponseDTO.class);
        return logindto;
    }

    public void insert(UserInsertReqDTO insertReqDTO) {
        User user = new User(insertReqDTO.getUserName(),
                insertReqDTO.getEmail(),
                insertReqDTO.getPassword(),
                insertReqDTO.getPhoneNum());
        dao.insert(user);
    }

    public Optional<User> findById(String userId) {
        Optional<User> user = dao.findById(Long.valueOf(userId));
        return user;
    }

    public List<User> findAll() {
        List<User> users = dao.findAll();
        return users;
    }

    public void update(UserDTO dto) {
        User user = new User(dto.getUserId(),
                dto.getUserName(),
                dto.getPassword(),
                dto.getPhoneNum());
        dao.update(user);
    }

    public void delete(UserDeleteDTO dto) {
        Optional<User> user = dao.findById(dto.getUserId());
        dao.delete(user.orElse(null));
    }

    public void updateRole(UserRoleDTO dto) {
        User user = new User(dto.getUserId(),
                dto.getRole());
        dao.adminUpdate(user);
    }

}
