package com.example.mimi.il.dao;

import com.example.mimi.il.UserDTO;
import com.example.mimi.il.UserDeleteDTO;
import com.example.mimi.il.entity.UsersEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {
    private final EntityManager em;

    // 생성
    @Override
    public void insert(UsersEntity userE) {
        em.persist(userE);
    }

    @Override
    public UsersEntity findById(Long userId) {
        return em.find(UsersEntity.class, userId);
    }

    @Override
    public List<UsersEntity> findAll() {
        List<UsersEntity> list =
                em.createQuery("select u from UsersEntity u", UsersEntity.class).getResultList();
        return list;
    }

    @Override
    public void update(UserDTO dto) {
        UsersEntity updateuser = em.find(UsersEntity.class, dto.getUserId());
        System.out.println(updateuser);
        System.out.println();
        updateuser.setUserName(dto.getUserName());
        updateuser.setPassword(dto.getPassword());
        updateuser.setPhoneNum(dto.getPhoneNum());
        System.out.println(updateuser+ "-----------------------------");
    }

    @Override
    public void delete(UserDeleteDTO dto) {
        System.out.println(dto + "===============================");
        UsersEntity user = em.find(UsersEntity.class, dto.getUserId());
        em.remove(user);
    }

    @Override
    public void adminUpdate(UsersEntity dto) {
        UsersEntity adminupdate = em.find(UsersEntity.class, dto.getUserId());
        adminupdate.setRole(dto.getRole());
    }
}
