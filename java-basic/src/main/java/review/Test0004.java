package review;

/**
 * @author luzc
 * @date 2020/8/27 14:38
 * @desc
 *
 *   1：构造方法可以被重载，一个构造方法可以通过this关键字调用另一个构造方法，this语句必须位于构造方法的第一行；
 *     重载：方法的重载(overload)：重载构成的条件：方法的名称相同，但参数类型或参数个数不同，才能构成方法的重载。
 *   2 当一个类中没有定义任何构造方法，Java将自动提供一个缺省构造方法；
 *   3 子类通过super关键字调用父类的一个构造方法；
 *   4 当子类的某个构造方法没有通过super关键字调用父类的构造方法，通过这个构造方法创建子类对象时，会自动先调用父类的缺省构造方法
 *   5 构造方法不能被static、final、synchronized、abstract、native修饰，但可以被public、private、protected修饰；
 *   6 构造方法不是类的成员方法；
 *   7 构造方法不能被继承。
 *
 */
public class Test0004 {
    public Test0004(){

    }
}
