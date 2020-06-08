/**
 * @author luzc
 * @date 2020/6/6 17:14
 * @desc 两个线程可以操作初始值为0的一个变量
 * 一个+1，一个-1.交替进行，共进行10轮，变量初始值变为0
 * <p>
 * 1；高内聚低耦合前提
 * 2：判断+干活+通知
 * 3：防止线程的虚假唤醒，只要有wait和while判断(多线程线程调度判断不能用if，要用while)
 */
public class ProdConsumer {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}

class AirCondition {
    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        //1 判断
        if (num != 0) {
            this.wait();
        }
        // 2 干活
        num++;
        System.out.println(Thread.currentThread().getName()+"\t"+num);
        //3 通知
        this.notifyAll();

    }

    public synchronized void decrement() throws InterruptedException{
        //1 判断
        if (num == 0) {
            this.wait();
        }
        // 2 干活
        num--;
        System.out.println(Thread.currentThread().getName()+"\t"+num);
        //3 通知
        this.notifyAll();
    }
}