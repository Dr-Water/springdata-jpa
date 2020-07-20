package com.ratel.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: springdata-jpa
 * @description: 科目
 * @author: fuyongnan
 * @create: 2020-07-17
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    private Integer id;

    /**
     * 当数据库字段和属性名一致的时候，不用加@column注解（如：数据库字段为：subject_name,属性为：subjectName）
     * 目前实验的效果是如果数据字段是：subject_name
     *
     * @column字段的name数据库字段名          属性名     映射是否成功
     *          subject_name                myName           是
     *          subjectName                 myName           是
     *          subject_Name                myName           是
     *          subjectName                subjectName       是
     *          subject_name               subjectName       是
     *          subject_Name               subjectName       是
     */
    //@Column(name = "subjectName")
    //@Column(name = "subject_Name")
   //@Column(name = "subject_Name")
    private String subjectName;
}
