package com.atguigu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Description: <br/>
 * date: 2022/12/26$ 9:54$<br/>
 *
 * @author: lanjiwei <br/>
 */

//将此类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {
    //设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex,Model model){
        //ex表示控制器方法的异常
        model.addAttribute("ex",ex);
        return "error";
    }
}
