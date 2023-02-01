package com.atguigu3.bean;

/**
 * Description: <br/>
 * date: 2022/11/24$ 10:55$<br/>
 *
 * @author: lanjiwei <br/>
 */


import java.util.Date;

/**
 * ORM编程思想
 * 一个数据表对于一个java类
 * 表中的一条记录对于java类的一个对象
 * 表中的一个字段对于java类的一个属性
 */
public class Customer {

    private int id ;
    private String name;
    private String email;
    private Date birth;

    public Customer() {
    }

    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
