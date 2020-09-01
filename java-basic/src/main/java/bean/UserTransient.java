package bean;

import java.io.*;

/**
 * @author luzc
 * @date 2020/8/18 8:35
 * @desc
 */
public class UserTransient implements Serializable {
    private static final long serialVersionUID = 123456L;

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

    private transient int age;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Test{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeUser();
        deSerializeUser();
    }

    private static void serializeUser() throws IOException {
        UserTransient user = new UserTransient();
        user.setName("Java的架构师技术栈");
        user.setAge(24);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D://dataNode/template"));
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        System.out.println("添加了transient的关键字序列化：age="+user.getAge());

    }

    private static void deSerializeUser() throws IOException, ClassNotFoundException {
        File file = new File("D://dataNode/template");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        UserTransient newUser = (UserTransient)objectInputStream.readObject();
        System.out.println("添加了transient的关键字序列化：age="+newUser.getAge());
    }
}
