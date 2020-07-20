package com.ratel.jpa;

import com.ratel.jpa.dao.RoleDao;
import com.ratel.jpa.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Roleests {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void JoinTest(){
        List<Role> list = roleDao.findAll();
        list.forEach(e->e.getUserList().forEach(System.out::println));
    }



}
