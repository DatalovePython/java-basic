package thread.concurrent;

/**
 * @author luzc
 * @date 2021/4/7 15:42
 * @desc
 */
public class VolatileVisibilityTest {

    // 此时各个线程间 工作内存中数据隔离，无法感知到其他线程的工作内存中值的改变
//    private static boolean initFlag = false;

    // 保证了共享变量在多个线程的工作内存中互相可见性
    private static volatile boolean initFlag = false;


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting data");
                while (!initFlag){

                }
                System.out.println("=================");
            }
        }).start();

        // 确保线程1执行完成后才执行线程2
        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        }).start();
    }

    private static void prepareData(){
        System.out.println("prepare data ....");
        initFlag = true;
        System.out.println("prepare data end....");
    }
}
