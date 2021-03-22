package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luzc
 * @date 2020/8/3 10:48
 * @desc
 */
public class NewFixedThreadPool {
    public static void main(String[] args) {
        /**
         *创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
         * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            final int index = i;
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {

                        String threadName = Thread.currentThread().getName();
                        System.out.println("执行：" + index + "，线程名称：" + threadName);
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
//            fixedThreadPool.execute(() -> {
//                try {
//
//                    String threadName = Thread.currentThread().getName();
//                    System.out.println("执行：" + index + "，线程名称：" + threadName);
//                    Thread.sleep(2000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
        }
        fixedThreadPool.shutdown();
        while (true){
            if (fixedThreadPool.isTerminated()){
                System.out.println("所有线程执行结束！");
                break;
            }

        }



    }
}
