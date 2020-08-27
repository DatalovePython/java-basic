package review;

/**
 * @author luzc
 * @date 2020/8/27 15:15
 * @desc 类加载顺序
 * 最先初始化的是静态域，静态域包含静态变量，静态块，静态方法
 * 其中需要初始化的静态变量和静态块
 * 所以顺序是 t1,t2，静态块
 */
public class Test0006 {
    public static void main(String[] args) {
        B t = new B();
    }
}

class B {
    public static B t1 = new B();
    public static B t2 = new B();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }
}
