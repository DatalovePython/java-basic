package lock;

/**
 * @author luzc
 * @date 2021/3/22 16:32
 * @desc 同步方法
 */
public class ReEnterLockDemoMethod {

    public synchronized void m1(){
        System.out.println("======外层");
        m2();
    }

    public synchronized void m2(){
        System.out.println("======中层");
        m3();
    }

    public synchronized void m3(){
        System.out.println("======内层");
    }

    public static void main(String[] args) {
        new ReEnterLockDemoMethod().m1();
    }
}
