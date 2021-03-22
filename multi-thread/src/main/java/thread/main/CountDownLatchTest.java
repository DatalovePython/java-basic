package thread.main;

/**
 * @author luzc
 * @date 2020/8/3 17:20
 * @desc 1.声明计数器线程个数：
 * <p>
 * CountDownLatch latch= new CountDownLatch(2);
 * <p>
 * 2.线程启动带参数latch:
 * <p>
 * Worker worker1= new Worker("zhang san" , 5000, latch);
 * <p>
 * 3.线程启动,主线程阻塞：
 * <p>
 * worker1.start();
 * latch.await();
 * <p>
 * 4.线程run()方法中计数器技术开始：
 * <p>
 * public void run(){
 * System. out.println("Worker " +workerName +" do work begin at "+sdf.format( new Date()));
 * doWork(); //工作了
 * latch.countDown();//工人完成工作，计数器减一
 * }
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);//两个工人的协作
        Worker worker1 = new Worker("zhang san", 2000, latch);
        Worker worker2 = new Worker("li si", 3000, latch);
        worker1.start(); //
        worker2.start(); //
        latch.await(); //等待所有工人完成工作
        System.out.println("all work done at " + sdf.format(new Date()) + " " + Thread.currentThread().getName());
    }


    static class Worker extends Thread {
        String workerName;
        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        public void run() {
            System.out.println("Worker " + workerName + " do work begin at " + sdf.format(new Date()));
            doWork(); //工作了
            System.out.println("Worker " + workerName + " do work complete at " + sdf.format(new Date()));
            latch.countDown();//工人完成工作，计数器减一

        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
