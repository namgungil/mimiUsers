package com.example.mimi.il.dao;

import com.example.mimi.il.entity.UsersEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserDAOImplTest {
    @Autowired
    private UserDAO dao;

    @Test
    void insert() {
        dao.insert(new UsersEntity("남궁일", "il1358@naver.com", "1234", "01033744108"));
        dao.insert(new UsersEntity("il", "il1358@gmail.com", "2345", "01098765432"));
    }



    @Test
    void findById() {
        UsersEntity user = dao.findById(1L);
        System.out.println(user);
    }

    @Test
    void findAll() {
        List<UsersEntity> list = dao.findAll();
        System.out.println(list);
    }

    @Test
    void update() {
//        dao.update(new UsersEntity(1l,"111","4567", "01012345678"));
        System.out.println(dao.findById(1L));
    }

    @Test
    void adminUpdate() {
        dao.adminUpdate(new UsersEntity(2L, true));
    }

    @Test
    void delete() {
/*        dao.delete("2");
        System.out.println(dao.findAll());*/
    }
}