package com.ratel.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


/**
 * @program: springdata-jpa
 * @description:
 * @author: fuyongnan
 * @create: 2020-07-17
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "score")
public class Score {
    @Id
    private Integer id;
    private Integer sid;
    private int score;


    /**
     * 测试一对一
     */
    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    /**
     * 测试一对多
     */
    @ManyToOne
    @JoinColumn(name="sid",insertable=false ,updatable=false)
    private Student student;

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", sid=" + sid +
                ", score=" + score +
                ", subject=" + subject +
                //这个地方一定要重写，不能再获取整个student对象，应该具体到某个(或多个除scoreList外的)属性，否则会无线递归死循环
                ", student=" + //student.getName() +
                '}';
    }
}
