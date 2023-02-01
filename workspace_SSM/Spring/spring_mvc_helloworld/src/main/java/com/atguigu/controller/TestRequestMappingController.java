package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description: <br/>
 * date: 2022/12/22$ 13:56$<br/>
 *
 * @author: lanjiwei <br/>
 */

/**
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    //此时控制器方法所匹配的请求的请求路径是/test/hello
    @RequestMapping(
            value = "/hello",
            method = RequestMethod.GET)
    public String hello(){
        return "success";
    }


    @RequestMapping("/a?a/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id ,@PathVariable("username") String username){
        System.out.println("username："+username);
        System.out.println("id"+id);
        return "success";
    }

}
