package com.example.mimi.il.dao;

import com.example.mimi.il.dto.UserDTO;
import com.example.mimi.il.dto.UserDeleteDTO;
import com.example.mimi.il.dto.UserRoleDTO;
import com.example.mimi.il.entity.User;
import com.example.mimi.il.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {
    private final UserRepository repository;

    @Override
    public User login(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    // 생성
    @Override
    public void insert(User userE) {
        repository.save(userE);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return repository.findById(userId);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(User user) {
        Optional<User> updateuser = repository.findById(user.getUserId());
//        System.out.println(updateuser);
//        System.out.println();
        updateuser.get().setUserName(user.getUserName());
        updateuser.get().setPassword(user.getPassword());
        updateuser.get().setPhoneNum(user.getPhoneNum());
//        System.out.println(updateuser+ "-----------------------------");
    }

    @Override
    public void delete(User user) {
//        System.out.println(dto + "===============================");
        User deleteUser = repository.findById(user.getUserId()).get();
        repository.delete(deleteUser);
    }

    @Override
    public void adminUpdate(User user) {
        Optional<User> adminupdate = repository.findById(user.getUserId());
        adminupdate.get().setRole(user.getRole());
    }
}
