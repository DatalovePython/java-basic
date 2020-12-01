

/**
 * @author luzc
 * @date 2020/6/9 14:38
 * @desc
 */

public class ReflectTest {

    public static void main(String[] args) throws Exception {

        Person person = new Person("jack", 25);

        // test get private value
        System.out.println("jack's name:" + ReflectionUtil.getValue(person, "name"));
        System.out.println("jack's age:" + ReflectionUtil.getValue(person, "age"));

        // test set private value
        ReflectionUtil.setValue(person, "name", "jason");
        ReflectionUtil.setValue(person, "age", 10);
        System.out.println("jack's name:" + ReflectionUtil.getValue(person, "name"));
        System.out.println("jack's age:" + ReflectionUtil.getValue(person, "age"));

        // test call private method
        String result = (String) ReflectionUtil.callMethod(person, "getInfo", new Class[] { String.class, int.class },
                new Object[] { "I hava ", 4 });
        System.out.println("result: " + result);
    }
}