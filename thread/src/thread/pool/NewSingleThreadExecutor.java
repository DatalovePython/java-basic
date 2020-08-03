package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luzc
 * @date 2020/8/3 14:18
 * @desc 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务
 * <p>
 * 按照指定顺序执行。
 */
public class NewSingleThreadExecutor {
    public static void main(String[] args) {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {

                public void run() {
                    try {

                        System.out.println(index);

                        Thread.sleep(2000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                }
            });

        }
    }
}
