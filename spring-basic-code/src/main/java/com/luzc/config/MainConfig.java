package com.luzc.config;

import com.luzc.bean.Person;
import com.luzc.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.logging.Filter;

/**
 * @author luzc
 * @date 2020/8/18 11:03
 * @desc 配置类=配置文件
 */
//告诉spring这是一个配置类
@Configuration

@ComponentScans(value = {
//        //include 只包含那些
//        @ComponentScan(value = "com.luzc", excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
//                        Controller.class, Service.class
//                })
//
//        }, useDefaultFilters = false),
//        exclude 排除那些
        @ComponentScan(value = "com.luzc", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
//                        Controller.class, Service.class
//                }),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
//                        BookService.class
//                }),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {
                        MyTypeFilter.class
                })
        })

})

//@ComponentScan value:指定要扫面的包
//Filter.Annotation 按照注解
//Filter.ASSIGNABLE_TYPE 按照给定的类型
//Filter.ASPECTJ 按照ASPECTJ表达式类型
//Filter.REGEX 使用正则表达式
//Filter.CUSTOM 使用自定义规则

public class MainConfig {

    //给容器中注册一个bean，类型为返回值的类型。id默认是方法名作为id
    @Bean("person")
    public Person person() {
        return new Person("LISI", 20);
    }
}
