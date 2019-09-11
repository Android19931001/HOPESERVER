package com.hope.service.loongStudent.domain;

import base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * @author wangning
 */

@Data
@Getter
@Setter
@TableName("loong_student")
public class LoongStudentEntity extends BaseEntity{

    /**
     * 表名主键
     */
    private int id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private int age;

}
