/*
1   故障现象
java.util.ConcurrentModificationException
多线程访问异常
2   导致原因
3   解决方法
    3.1  new Vector
    3.2 Collections.synchronizedList(new ArrayList<>())
    3.3
4   优化建议


 */

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotSafeDemo3 {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <=30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,9));
                System.out.println(list);
            },String.valueOf(i)).start();


        }
    }
}
