package com.luzc.config;

import com.luzc.condition.LinuxCondition;
import com.luzc.condition.MyImportSelector;
import com.luzc.condition.WindowCondition;
import com.luzc.bean.Color;
import com.luzc.bean.Person;
import com.luzc.bean.Red;
import org.springframework.context.annotation.*;

/**
 * @author luzc
 * @date 2020/8/18 14:02
 * @desc
 */
//满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional({WindowCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class})
//import 导入组件，id默认是组件的全类名
public class MainConfig2 {


    //默认是单实例的
    /*
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * scope：调整作用域
     * prototype:多实例的 ioc容器启动并不会调用方法创建对象，每次获取才会调用方法创建对象
     * singleton：单实例（默认值) ioc容器启动会调用方法创建对象放到ioc容器中，以后每次都是直接从容器中拿（map.get)
     * request:同一次请求用同一个实例
     * session：同一个session用一个实例
     *
     *  @Lazy
     * 懒加载：针对单实例bean
     *          单实例bean：默认启动的时候加载
     *          懒加载：容器启动不创建对象
     *          第一次使用（获取的时候）创建对象
     *
     *
    * */


//    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加person");
        return new Person("张三", 24);
    }

    /*
    * @Conditional({}) 按照一定的条件判断，满足条你家给容器中注册bean
    *
    * 如果系统是win，给容器注册bill
    * 如果是linux，注册linux
    *
    * */
    @Bean("bill")
    public Person person01(){
        return new Person("bill gates",80);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",82);
    }

    /*
    * 给容器中注册组件
    * 1：包扫描+组件标注注解（@Controller,@Service,@Repository，@Component),自己写的类
    * 2:@Bean，导入第三包里面的组件
    * 3：@Import[快速给容器中导入组件]
    *       @Import(要导入到容器中的组件）：容器中就会自动注册这个组件，id默认是全类名
    *       importSelector:返回需要导入的组件的全类名数组
    *
    * */

}


