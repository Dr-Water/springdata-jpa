package com.ratel.jpa;

import com.ratel.jpa.dao.StudentDao;
import com.ratel.jpa.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTests {

    @Autowired
    private StudentDao studentDao;


    /**
     * 测试一对多
     */
    @Test
    public void JoinTest(){
        List<Student> list = studentDao.findAll();
        list.forEach(System.out::println);
    }



}
