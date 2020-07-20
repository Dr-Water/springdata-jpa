package com.ratel.jpa.entity;

/**
 * @program: springdata-jpa
 * @description:
 * @author: fuyongnan
 * @create: 2020-07-09
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    private String username;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "email", length = 64)
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

