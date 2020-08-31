package review;

/**
 * @author luzc
 * @date 2020/8/31 17:29
 * @desc
 *
 * 静态块：用static申明，JVM加载类时执行，仅执行一次
 * 构造块：类中直接用{}定义，每一次创建对象时执行
 * 执行顺序优先级：静态块>main()>构造块>构造方法
 * 静态块按照申明顺序执行，先执行Test t1 = new Test();
 * 所有先输出blockA，然后执行静态块，输出blockB，最后执行main
 * 方法中的Test t2 = new Test();输出blockA。
 *
 *首先，需要明白类的加载顺序。
 * (1) 父类静态对象和静态代码块
 * (2) 子类静态对象和静态代码块
 * (3) 父类非静态对象和非静态代码块
 * (4) 父类构造函数
 * (5) 子类 非静态对象和非静态代码块
 * (6) 子类构造函数
 * 其中：类中静态块按照声明顺序执行，并且(1)和(2)不需要调用new类实例的时候就执行了(意思就是在类加载到方法区的时候执行的)
 * 2.因而，整体的执行顺序为
 * public static Test  t1 = new Test();         //(1)
 * static
 * {
 * System.out.println("blockB");                //(2)
 * }
 * Test t2 =new Test();                             //(3)
 * 在执行
 * (1)时创建了一个Test对象，在这个过程中会执行非静态代码块和缺省的无参构造函数，
 * 在执行非静态代码块时就输出了blockA；然后执行
 * (2)输出blockB；执行
 * (3)的过程同样会执行非静态代码块和缺省的无参构造函数，在执行非静态代码块时输出blockA。因此，最终的结果为
 *
 * blockA
 * blockB
 * blockA
 *
 */

public class Test0009
{
    public static Test0009 t1 = new Test0009();
    {
        System.out.println("blockA");
    }
    static
    {
        System.out.println("blockB");
    }
    public static void main(String[] args)
    {
        Test0009 t2 = new Test0009();
    }
}
