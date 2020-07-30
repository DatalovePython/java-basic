package main.java.prototype;

import main.java.util.Person;

import java.util.ArrayList;

/**
 * @author luzc
 * @date 2020/7/30 14:03
 * @desc 用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
 */
public class  Prototype {
    public static void main(String [] args) throws Exception{
        Person p=new Person();
        p.setAge(18);
        p.setName("张三");
        p.setHeight(178);
        p.setWeight(65);

        ArrayList <String> hobbies=new ArrayList<String>();
        hobbies.add("篮球");
        hobbies.add("编程");
        hobbies.add("长跑");
        p.setHobbies(hobbies);

        System.out.println(p);

        Person p1= (Person) p.clone();
        System.out.println(p1);

        p1.setName("李四");
        p1.getHobbies().add("游泳");
        System.out.println(p);
        System.out.println(p1);
    }
}
