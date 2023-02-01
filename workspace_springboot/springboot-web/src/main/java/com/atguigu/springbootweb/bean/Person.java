package com.atguigu.springbootweb.bean;

import lombok.Data;

import java.util.Date;

/**
 * Description: <br/>
 * date: 2023/1/4$ 16:50$<br/>
 *
 * @author: lanjiwei <br/>
 */
@Data
public class Person {
   private String userName;
   private Integer age;
   private Date birth;
   private Pet pet;

}
