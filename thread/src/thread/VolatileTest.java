package thread;

import java.util.concurrent.TimeUnit;

/*
    1:一开始如果不给number 加 volatie 关键字，则线程之间是不可见的。例如A线程改了主内存中的number 值，其他线程不可见
    总而言之，volatile 关键字，实现了线程间的立即通信，是JVM提供的轻量级的同步机制，乞丐版的synchronized

    内存模型：各个线程对主内存中共享变量的操作都是各个线程各自拷贝到自己的工作内存进行操作后再写回主内存中的

    2：验证volatile 不保证原子性
    原子性即保证整体完整，要么成功要么失败。不能在任务中被加塞

 */
class MyData{
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }
    //即使加了volatile 也不保证原子性
    public void addPlusPlus(){
        number++;
    }
}

public class VolatileTest {
    public static void main(String[] args) {
        MyData myData = new MyData();

        for(int i= 1;i<=20;i++){
            new Thread(()->{
                for (int j = 1; j <=1000 ; j++) {
                    myData.addPlusPlus();
                }

            },String.valueOf(i)).start();
        }

        //后台默认两个线程，一个main，一个gc
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value: "+myData.number);
    }

    //volatile 保证可见性，及时通知其他线程主物理内存的值被修改
    public static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in ");
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value: "+myData.number);

        },"AAA").start();

        while (myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
