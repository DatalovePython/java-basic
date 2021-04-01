package gc;

import java.lang.ref.WeakReference;

/**
 * @author luzc
 * @date 2021/4/1 14:29
 * @desc
 * 弱引用
 * 只要被垃圾回收器看到，就被回收
 *
 */
public class T03WeakReference {

    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
    }
}
