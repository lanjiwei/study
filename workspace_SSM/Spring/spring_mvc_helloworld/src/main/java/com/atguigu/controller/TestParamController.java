package com.atguigu.controller;

import com.atguigu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: <br/>
 * date: 2022/12/22$ 15:19$<br/>
 *
 * @author: lanjiwei <br/>
 */

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam("userName") String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param/entity")
    public String getParamByEntity(User user){
        System.out.println(user);
        return "success";
    }

}
