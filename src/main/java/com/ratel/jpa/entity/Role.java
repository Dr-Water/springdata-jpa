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
@Table(name = "role")
public class Role {

    @Id
    private String id;

    private String roleName;

    /**
     * 测试多对多
     */
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<MyUser> userList;

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

