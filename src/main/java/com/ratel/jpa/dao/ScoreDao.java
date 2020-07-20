package com.ratel.jpa.dao;

/**
 * @program: springdata-jpa
 * @description:
 * @author: fuyongnan
 * @create: 2020-07-09
 **/


import com.ratel.jpa.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreDao extends JpaRepository<Score, Integer> , JpaSpecificationExecutor<Score> {

    @Query(value = "SELECT sc.* ,s.subject_name FROM score sc left JOIN `subject` s on sc.subject_id=s.id GROUP BY sc.sid HAVING COUNT(1)=1",nativeQuery = true)
    List<Score> findAllJoin();


    List<Score> findTop2ByScore(int score);
}
