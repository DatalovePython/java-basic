package main.java.util;

import java.util.ArrayList;

/**
 * @author luzc
 * @date 2020/7/28 11:21
 * @desc
 */
public class Person implements Cloneable {
    private String name;
    private int age;
    private double height;
    private double weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private ArrayList<String> hobbies=new ArrayList<String>();

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", hobbies=" + hobbies +
                '}';
    }

    //todo: 建造者模式
    //建造者模式中重载各种构造方法
    public Person(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    //建造者模式改造
    private Person(Builder builder) {
        this.name=builder.name;
        this.age=builder.age;
        this.height=builder.height;
        this.weight=builder.weight;
    }

    public static class Builder {
        private String name;
        private int age;
        private double height;
        private double weight;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }


    //todo:原型模式写法一
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person person=null;
        try {
            person=(Person)super.clone();
            person.name=this.name;
            person.weight=this.weight;
            person.height=this.height;
            person.age=this.age;
            //这样只是浅拷贝，两个对象指向的引用是同一个
//            person.hobbies=this.hobbies;
            //这样才是深拷贝
            person.hobbies=(ArrayList<String>)this.hobbies.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }

    //todo:原型模式写法二
//    @Override
//    public Object clone(){
//        return new Person(this);
//    }
//
//    public Person(Person person){
//        this.name=person.name;
//        this.weight=person.weight;
//        this.height=person.height;
//        this.age=person.age;
//        this.hobbies= new ArrayList<String>(hobbies);
//    }




}
