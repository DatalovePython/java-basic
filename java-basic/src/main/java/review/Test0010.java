package review;

/**
 * @author luzc
 * @date 2020/9/1 15:49
 * @desc
 *
 * 这道题主要考的是"|"与"||"的区别
 * 用法：condition 1 | condition 2、condition 1 || condition 2
 * "|"是按位或：先判断条件1，不管条件1是否可以决定结果（这里决定结果为true)，都会执行条件2
 * "||"是逻辑或：先判断条件1，如果条件1可以决定结果（这里决定结果为true)，那么就不会执行条件2
 *
 */

public class Test0010 {
    private static int j = 0;

    private static Boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = i < 10 | methodB(4);//位运算符,代表或
        b = i < 10 || methodB(8);//逻辑运算符，称为逻辑或操作符

    }

    public static void main(String args[]) {
        methodA(0);
        System.out.println(j);
    }
}
