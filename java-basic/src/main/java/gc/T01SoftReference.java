package gc;

import java.lang.ref.SoftReference;

/**
 * @author luzc
 * @date 2021/4/1 14:21
 * @desc
 * 软引用,内存不足才会被回收，适合用于缓存；空间可以给你先占着，但是需要的时候必须让出来
 * 倒是可以做内存警告,当对象被回收时则说明系统所需要的内存不足,那么就可以发邮件通知相关人员.
 * 此处可现将 -Xmx = 20m
 *
 */
public class T01SoftReference {

    // 占据10m内存空间
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);

        System.out.println(m.get());
        System.gc();
        // 确保gc可以执行完成
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());

        // 再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1024*1024*15];
        System.out.println(m.get());
    }



}
