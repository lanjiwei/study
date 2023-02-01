package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljw
 * @since 2023-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User  implements Serializable {

    private static final long serialVersionUID = 1L;

//    @TableId注解的value属性用于指定主键的字段
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
//     指定属性所对应的字段名
    @TableField("user_name")
    private String name;

    private Integer age;

    private String password;

    private String gender;

    @TableLogic
    private Integer isDeleted;


}
