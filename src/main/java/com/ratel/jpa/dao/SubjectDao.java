package com.ratel.jpa.dao;

/**
 * @program: springdata-jpa
 * @description:
 * @author: fuyongnan
 * @create: 2020-07-09
 **/


import com.ratel.jpa.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubjectDao extends JpaRepository<Subject, Integer> , JpaSpecificationExecutor<Subject> {





}
