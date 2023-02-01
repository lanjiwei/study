package com.atguigu.springbootweb.controller;

import com.atguigu.springbootweb.bean.Person;
import com.atguigu.springbootweb.bean.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: <br/>
 * date: 2022/12/29$ 9:13$<br/>
 *
 * @author: lanjiwei <br/>
 */
@RestController
public class ParameterTestController {

    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(18);
        person.setBirth(new Date("1999/10/1"));
        person.setUserName("zhangsan");
        return person;
    }


    @PostMapping("/saveuser")
    public Person saveUser(Person person){
        return person;
    }


    @RequestMapping("/car/{id}/owner/{name}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("name") String name,
                                      @PathVariable Map<String,String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters
                                      ){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("User-Agent",userAgent);
        map.put("age",age);
        map.put("inters",inters);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    @GetMapping("/cars/{path}")
    public Map<String,Object> carsSell(@MatrixVariable("low") Integer low,
                                       @MatrixVariable("brand") List<String> brand,
                                       @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
}
