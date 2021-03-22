package com.luzc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luzc
 * @date 2020/8/18 11:01
 * @desc
 */

@SpringBootApplication
public class MainTest {

    public static void main(String[] args) {
        SpringApplication.run(MainTest.class, args);
    }

//    public static void main(String[] args) {
//        //从配置文件中获取
////        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
////        Person person = (Person) classPathXmlApplicationContext.getBean("person");
////        System.out.println(person);
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//        Person bean = annotationConfigApplicationContext.getBean(Person.class);
//        System.out.println(bean);
//
//        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
//        for (String string : beanNamesForType) {
//            System.out.println(string);
//        }
//
//    }
}
