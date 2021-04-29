package cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luzc
 * @date 2021/4/29 10:35
 * @desc
 */
public class AtomicIntegerTest {
    // 因为 volatile 只保证了可见性， i++ 是非原子操作，可能出现将错误值写回主内存的现象。
//    private static volatile int race = 0;

    // 如果使用原子类来操作
    private static AtomicInteger atomicRace = new AtomicInteger(0);

    private static final int THREADS_COUNT = 20;

    private static void increase(){

//        race++;
        atomicRace.getAndIncrement();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 10000; i1++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount()>1){
            Thread.yield();
        }

        System.out.println(atomicRace);


    }

}
