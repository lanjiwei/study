package com.atguigu.mybatis.entity;

/**
 * Description: <br/>
 * date: 2022/12/8$ 15:06$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class User {




    private String name;
    private Integer age;
    private String password;
    private String gender;

    public User( String name, Integer age, String password, String gender) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.gender = gender;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +

                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }
}
