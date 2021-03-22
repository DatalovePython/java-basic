package thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author luzc
 * @date 2020/8/3 14:17
 * @desc 创建一个定长线程池，支持定时及周期性任务执行。
 * 表示延迟 1 秒后每 3 秒执行一次。
 */
public class NewScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        scheduledThreadPool.schedule(new Runnable() {
            public void run() {

                System.out.println("delay 3 seconds");
            }

        }, 3, TimeUnit.SECONDS);
    }
}
