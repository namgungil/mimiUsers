package com.example.mimi.il.dao;

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
    public void insert(UsersEntity dto) {
        em.persist(dto);
    }

    @Override
    public UsersEntity findById(String userId) {
        return em.find(UsersEntity.class, Long.parseLong(userId));
    }

    @Override
    public List<UsersEntity> findAll() {
        List<UsersEntity> list =
                em.createQuery("select u from UsersEntity u", UsersEntity.class).getResultList();
        return list;
    }

    @Override
    public void update(UsersEntity dto) {
        UsersEntity updateuser = em.find(UsersEntity.class, dto.getUserId());
        updateuser.setUserName(dto.getUserName());
        updateuser.setPassword(dto.getPassword());
        updateuser.setPhoneNum(dto.getPhoneNum());
    }

    @Override
    public void delete(String userId) {
        UsersEntity user = em.find(UsersEntity.class, Long.parseLong(userId));
        em.remove(user);
    }

    @Override
    public void adminUpdate(UsersEntity dto) {
        UsersEntity adminupdate = em.find(UsersEntity.class, dto.getUserId());
        adminupdate.setRole(dto.getRole());
    }
}
