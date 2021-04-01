package gc;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * @author luzc
 * @date 2021/4/1 14:05
 * @desc 引用测试
 */
public class T02StrongReference {

    public static void main(String[] args) throws IOException {

        // 强引用
        M a = new M();
        // 引用中断
        a = null;
        System.gc();
        System.out.println(a);
        System.in.read();//阻塞main线程，给垃圾回收线程时间执行
    }
}


