package lock;

import java.util.concurrent.TimeUnit;

/**
 * @author luzc
 * @date 2020/6/6 10:44
 * @desc 8锁演示
 * 1:标准访问，先打印邮件还是短信（先邮件再短信）
 * 2：暂停4秒在邮件方法，哪个先（先邮件再短信）
 * 3: 新增普通sayHello方法，哪个先(先sayHello再邮件再短信)
 * 4: 两部手机，先打印邮件还是短信（先邮件再短信）
 * 5：两个静态方法，一个手机，先打印邮件还是短信（先邮件再短信）
 * 6：两个静态方法，两个手机，先打印邮件还是短信（先邮件再短信）
 * 7：一个静态方法，一个普通方法，一个手机，先打印邮件还是短信（先邮件再短信）
 * 8：一个静态方法，一个普通方法，两个手机，先打印邮件还是短信（先邮件再短信）
 *
 *
 * 核心就是，观察synchronized 锁的是什么对象
 * 当一个线程试图访问同步代码块时候。必须先获得该对象的锁，退出或者抛出异常时，则会释放该锁
 * 如果syn 作用在普通方法上，那么syn 锁住的是当时实例对象的 所有syn方法
 * 如果syn 作用在静态方法上，那么syn锁住的是整个类。该类实例化后所有的对象都会受到影响
 * 但是syn方法只对修饰了syn的起作用，对普通方法不不影响
 */
public class Lock8Demo5 {
    public static void main(String[] args) throws InterruptedException{
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(100);

        new Thread(()->{
            try {
                phone2.sendMsg();
//                phone.sayHello();
//                phone.sayHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();


    }
}

class Phone{
    private static String str = "abc";
    public synchronized void sendEmail() throws Exception{
//        Thread.sleep(4000);
        TimeUnit.SECONDS.sleep(4);
        System.out.println("*********sendEmail");
    }

    public synchronized void sendMsg() throws Exception{
        System.out.println("*********sendMsg");
    }

    public void sayHello() throws Exception{
        System.out.println("*********sayHello");
    }

}
