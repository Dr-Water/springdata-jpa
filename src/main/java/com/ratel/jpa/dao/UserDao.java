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
    /**
     *
     *根据jpa的命名规范进行查询，具体可参考：https://blog.csdn.net/java_zyq/article/details/85262373
     *但是这种查询方法无法进行连表查询
     **/
    List<User> findAllByIdIn(List<String> idList);

    List<User> findAllByIdInAndIdEquals(List<String> idList,String id);

    User findById(String id);


    /**
     * nativeQuery = true 使用原生的sql进行查询，这时候的表名要写成和数据库的一致的
     *
     **/
    @Query(value = "select u.* from tb_user u where  u.id in (?1)",nativeQuery = true)
    List<User> findAllByIdList(List<String> idList);

    /**
     * from后面是跟的实体类,由于实体类上加的有库表映射关系，最后jpa会自动映射为对应的表
     *
     **/
    @Query(value = "select u from User u where  u.id in (?1)")
    List<User> findByIdList(List<String> idList);



}
