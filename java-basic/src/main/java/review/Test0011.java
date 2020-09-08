package review;

/**
 * @author luzc
 * @date 2020/9/2 14:54
 * @desc
 * 应理解成，当对象作为参数传入方法时，参数等于传入对象的副本（持有对象的内存地址）。
 * 当副本指向一个新的内存地址时，原来的变量指向原来的地址，自然没有改变。
 * 而当改变对象的属性时，因为指向的是同一个内存地址，所以会引起原来的值的改变。
 *  https://blog.csdn.net/m18500961204/article/details/58153174
 */
import java.util.Arrays;

public class Test0011{
    public static void main(String[] args){
        int[] aa = {3, 2, 1};
        System.out.println(Arrays.toString(aa)); //[3, 2, 1]
        test(aa);
        System.out.println(Arrays.toString(aa)); //[3, 2, 1]
        test2(aa);
        System.out.println(Arrays.toString(aa)); //[4, 2, 1]
    }

    static void test(int[] a){
        a = new int[]{1, 2, 3};   //指向了新对象
    }

    static void test2(int[] a){
        if(a != null && a.length > 0)
            a[0]++;              //修改原来的那个对象
    }
}
