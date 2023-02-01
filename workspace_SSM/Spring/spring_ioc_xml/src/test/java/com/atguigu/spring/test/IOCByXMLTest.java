package com.atguigu.spring.test;

import com.atguigu.spring.entity.Clazz;
import com.atguigu.spring.entity.Person;
import com.atguigu.spring.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: <br/>
 * date: 2022/12/13$ 17:41$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class IOCByXMLTest {

    @Test
    public void testIOC(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*
        根据类型来获取bean时，在满足bean唯一性的前提下，
        其实只是看：『对象 instanceof 指定的类型』的返回结果，
         只要返回的是true就可以认定为和类型匹配，能够获取到。
        即通过bean的类型，bean所继承的类的类型，bean所实现的接口的类型都可以获取bean
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
        */

        Student student = ioc.getBean("StudentOne",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student studentTwo = ioc.getBean("StudentTwo", Student.class);
//        System.out.println(studentTwo);
        Student studentThree = ioc.getBean("StudentThree", Student.class);
        System.out.println(studentThree);

//        Clazz clazz = ioc.getBean(Clazz.class);
//        System.out.println(clazz);
    }



}
