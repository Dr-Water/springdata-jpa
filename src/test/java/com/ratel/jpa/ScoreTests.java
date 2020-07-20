package com.ratel.jpa;

import com.ratel.jpa.dao.ScoreDao;
import com.ratel.jpa.entity.Score;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreTests {

    @Autowired
    private ScoreDao scoreDao;

    @Test
    public void JoinTest(){
        List<Score> list = scoreDao.findAllJoin();
        System.out.println("查询结束");
       // list.forEach(System.out::println);
    }

    /**
     * 测试多对多
     */
    @Test
    public void findAll(){
        List<Score> list = scoreDao.findAll();
        list.forEach(System.out::println);
    }
    @Test
    public void findTop2(){
        List<Score> list = scoreDao.findTop2ByScore(88);
        list.forEach(System.out::println);
    }

}
