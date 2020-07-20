package com.ratel.jpa.entity;

/**
 * @program: springdata-jpa
 * @description:
 * @author: fuyongnan
 * @create: 2020-07-09
 **/

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class MyUser {

    @Id
    private String id;

    private String username;

    /**
     * 测试多对多
     */
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleList;

    @Override
    public String toString() {
        return "MyUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

