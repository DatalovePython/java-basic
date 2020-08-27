package review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luzc
 * @date 2020/8/27 10:36
 * @desc ArrayList,LInkedList的时间比较。
 *
 * ArrayList：增删慢，查询快。
 * 由于是数据组实现，需要连续的内存空间，如果删除数组中间的值，为了保证下标的有效性，需要将后面的数据往前移，所以删除慢。
 * 当插入A对象到B对象的前面时，需要将B对象和B对象之后的所有对象后移一位，再插入A对象。所以插入慢。
 * 数组的大小是固定的，如果数组满了，需要重新分配空间，new一个新数组并copy旧数据之后再增加新数据，所以增加慢。
 * 因为是连续内存空间，可以通过下标查询数据，所以查询快。
 *
 * LInkedList：增删快，查询慢。
 * 由于是链表实现，当前节点的next指向下一个节点，prev指向上一个节点，不需要连续的内存空间，所以增删快。
 * 因为不是连续内存空间，所以不能使用下标查询，只能通过next遍历，所以查询慢。
 */
public class Test0001 {
    public static void main(String[] args) {
        Object obj=new Object();
        List aList=new ArrayList();
        List bList=new LinkedList();

        long t1=System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            aList.add(0,obj);
        }
        long t2=System.currentTimeMillis()-t1;

        t1=System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            bList.add(0,obj);
        }
        long t3=System.currentTimeMillis()-t1;
        System.out.println("t1 "+t1);
        System.out.println("t2 "+t2);
        System.out.println("t3 "+t3);
    }
}
