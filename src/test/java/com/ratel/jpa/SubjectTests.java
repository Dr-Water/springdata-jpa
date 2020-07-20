package com.ratel.jpa;

import com.ratel.jpa.dao.SubjectDao;
import com.ratel.jpa.entity.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTests {

    @Autowired
    private SubjectDao subjectDao;

    @Test
    public void JoinTest(){
        List<Subject> list = subjectDao.findAll();
        list.forEach(System.out::println);
    }



}
