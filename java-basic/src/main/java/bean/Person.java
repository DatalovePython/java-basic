package bean;

/**
 * @author luzc
 * @date 2020/8/14 9:07
 * @desc
 */

public class Person implements Comparable<Person> {
    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    public void getString(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}
