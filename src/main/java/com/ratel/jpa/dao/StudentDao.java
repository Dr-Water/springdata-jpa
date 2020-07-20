package com.ratel.jpa.dao;

/**
 * @program: springdata-jpa
 * @description:
 * @author: fuyongnan
 * @create: 2020-07-09
 **/


import com.ratel.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentDao extends JpaRepository<Student, Integer> , JpaSpecificationExecutor<Student> {

    // @Query(value = "",nativeQuery = true)
     //List<Student> findAllJoin();



}
