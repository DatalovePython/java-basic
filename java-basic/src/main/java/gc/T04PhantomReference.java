package gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luzc
 * @date 2021/4/1 14:36
 * @desc
 * 虚引用
 * 一般只用在类库中，在工程项目中不太用
 * 的唯一作用就是当其指向的对象被回收之后，自己被加入到引用队列，用作记录该引用指向的对象已被销毁。
 * 虚引用使用场景主要由两个。它允许你知道具体何时其引用的对象从内存中移除。而实际上这是Java中唯一的方式。这一点尤其表现在处理类似图片的大文件的情况。
 * 当你确定一个图片数据对象应该被回收，你可以利用虚引用来判断这个对象回收之后在继续加载下一张图片。这样可以尽可能地避免可怕的内存溢出错误。
 * 当垃圾回收线程的时候给通知
 * 去队列里检查，如果有的话说明该对象要被引用
 *
 * 直接内存-> 堆外内存
 * nio zero-copy
 */
public class T04PhantomReference {

    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) throws InterruptedException {
        PhantomReference<M> mPhantomReference = new PhantomReference<>(new M(), QUEUE);

        // 获取不到
        System.out.println(mPhantomReference.get());
        //
        new Thread(()->{
            while (true){
                // 很快将内存占光
                LIST.add(new byte[1024*1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(mPhantomReference.get());
            }
        }).start();

        // 垃圾回收线程
        new Thread(()->{
            while (true){
                Reference<? extends M> poll = QUEUE.poll();
                if(poll != null){
                    System.out.println("---虚引用对象被jvm回收了---"+poll);

                }
            }
        }).start();

        Thread.sleep(500);

    }
}
