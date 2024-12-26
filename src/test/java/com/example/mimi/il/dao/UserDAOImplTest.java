package com.example.mimi.il.dao;

import com.example.mimi.il.dto.UserRoleDTO;
import com.example.mimi.il.entity.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserDAOImplTest {
    @Autowired
    private UserDAO dao;

    @Test
    void insert() {
        dao.insert(new User("남궁일", "il1358@naver.com", "1234", "01033744108"));
        dao.insert(new User("il", "il1358@gmail.com", "2345", "01098765432"));
    }



    @Test
    void findById() {
        Optional<User> user = dao.findById(1L);
        System.out.println(user);
    }

    @Test
    void findAll() {
        List<User> list = dao.findAll();
        System.out.println(list);
    }

    @Test
    void update() {
//        dao.update(new UsersEntity(1l,"111","4567", "01012345678"));
        System.out.println(dao.findById(1L));
    }

    @Test
    void adminUpdate() {
        dao.adminUpdate(new User(2L, true));
    }

    @Test
    void delete() {
/*        dao.delete("2");
        System.out.println(dao.findAll());*/
    }
}