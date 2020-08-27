package review;

/**
 * @author luzc
 * @date 2020/8/27 10:50
 * @desc synchronize 的问题
 *
 * 修饰非静态方法 锁的是this 对象
 *
 * 修饰静态方法 锁的是class对象
 */
public class Test0002 {
    private synchronized void a() {
    }
    private void b() {
        synchronized (this) {
        }
    }
    private synchronized static void c() {
    }
    private void d() {
        synchronized (Test0002.class) {
        }
    }
}
