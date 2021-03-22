package lock;

/**
 * @author luzc
 * @date 2021/3/22 16:15
 * @desc 可重入锁： 可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫可重入锁
 * <p>
 *
 *     同步代码块
 * 在一个 Synchronized 修饰的方法或代码块的内部
 * 调用本类的其他synchronized 修饰的方法或者代码块时，是永远可以得到锁的
 */
public class ReEnterLockDemoCodeArea {

    static Object objectLockA = new Object();

    public static void m1() {
        new Thread(() -> {
            synchronized (objectLockA){
                System.out.println(Thread.currentThread().getName()+"\t"+"------外层调用");
                synchronized (objectLockA){
                    System.out.println(Thread.currentThread().getName()+"\t"+"------中层调用");
                    synchronized (objectLockA){
                        System.out.println(Thread.currentThread().getName()+"\t"+"------外层调用");
                    }
                }
            }
        }, "thread name").start();
    }

    public static void main(String[] args) {
        m1();
    }
}
