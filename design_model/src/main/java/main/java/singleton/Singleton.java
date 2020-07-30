package main.java.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @author luzc
 * @date 2020/7/28 10:29
 * @desc 安卓开发中-设计模式-单例模式
 * https://www.cnblogs.com/lenkevin/p/8692490.html
 */
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton(){
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        int threadCount = 1000;
        for (int i = 0; i < threadCount; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Singleton.getInstance().hashCode());
                }
            }.start();
        }
        latch.countDown();
    }
}
