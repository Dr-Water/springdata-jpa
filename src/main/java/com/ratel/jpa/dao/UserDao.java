package com.ratel.jpa.dao;

/**
 * @program: springdata-jpa
 * @description:
 * @author: fuyongnan
 * @create: 2020-07-09
 **/


import com.ratel.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, String> , JpaSpecificationExecutor<User> {

    @Query(value = "select u.* from tb_user u where  u.id in (?1)",nativeQuery = true)
    //@Query(value = "select u.* from tb_user u where if( length (?1),u.id in (?1),1=1)",nativeQuery = true)
   // @Query(value = "select u from User u where nullif(?1,1=1) ")
    List<User> findAllByIdList(List<String> idList);

    /**
     ** paramString : 自定义 hql
     ** paramMap : hql中查询条件的参数
     ** start：数据开始条数
     ** max：最大数据条数
     **/
    // List<User> query(String paramString, Map paramMap, int start, int max);

    List<User> findAllByIdIn(List<String> idList);

    List<User> findAllByIdInAndIdEquals(List<String> idList,String id);

}
