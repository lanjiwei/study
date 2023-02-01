package com.atguigu.spring.test;

import com.atguigu.spring.entity.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: <br/>
 * date: 2022/12/13$ 17:24$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class HelloWorldTest {
    @Test
    public void test(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中的bean
        HelloWorld helloworld =(HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();
    }
}
