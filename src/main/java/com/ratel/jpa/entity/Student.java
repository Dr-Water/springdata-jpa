package com.ratel.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @program: springdata-jpa
 * @description: 学生实体类
 * @author: fuyongnan
 * @create: 2020-07-17
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    private Integer sid;
    private String name;


    /**
     * 测试一对多
     */
    @OneToMany(mappedBy = "student",fetch=FetchType.EAGER)
    private List<Score> scoreList;

}
