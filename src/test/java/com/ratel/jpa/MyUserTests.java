package com.ratel.jpa;

import com.ratel.jpa.dao.MyUserDao;
import com.ratel.jpa.entity.MyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUserTests {

    @Autowired
    private MyUserDao myUserDao;

    @Test
    public void JoinTest(){
        List<MyUser> list = myUserDao.findAll();
        list.forEach(e->e.getRoleList().forEach(System.out::println));
    }



}
