package test;

/**
 * @author luzc
 * @date 2020/8/17 15:24
 * @desc
 */

import java.io.Console;
import java.lang.String;
import java.util.HashMap;

public class lang {

    public static void main(String[] args) {
        int number = 10;
        //原始数二进制
        printInfo(number);
        int numberLeft = number << 1;
        //左移一位
        printInfo(numberLeft);
        int numberRight = number >> 1;
        //右移一位
        printInfo(numberRight);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }

    /**
     * 输出一个int的二进制数
     * @param num
     */
    private static void printInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}


