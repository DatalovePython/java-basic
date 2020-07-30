package main.java.builder;

import main.java.util.Person;


/**
 * @author luzc
 * @date 2020/7/28 11:15
 * @desc 定义将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 */
public class Builder {
    public static void main(String[] args) {
        /*
        * 可以想象一下这样创建的坏处，最直观的就是四个参数的构造函数的最后面的两个参数到底是什么意思，
        *
        * 可读性不怎么好，如果不点击看源码，鬼知道哪个是weight哪个是height。还有一个问题就是当有很多参数时，编写这个构造函数就会显得异常麻烦，
        * */
        Person p1=new Person();
        Person p2=new Person("张三");
        Person p3=new Person("李四",18);
        Person p4=new Person("王五",21,180);
        Person p5=new Person("赵六",17,170,65.4);

        //同构建造者模式改建
        Person.Builder builder=new Person.Builder();
        Person person=builder
                .name("张三")
                .age(18)
                .height(178.5)
                .weight(67.4)
                .build();

        System.out.println(person.toString());

    }
}


