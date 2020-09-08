package review;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author luzc
 * @date 2020/9/8 16:44
 * @desc
 *
 * jdk1.8中，当ArrayList中元素的数量是2个时，本应报错的却不报错了
 *
 * https://www.cnblogs.com/zhuyeshen/p/10956822.html
 *
 */
public class Test0013 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        // fixme: 当前并不报错，与数组内元素的数量有关。
        arrayList.add("abc");
        arrayList.add("def");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if("abc".equals(next))
                arrayList.remove(next);
        }
        System.out.println(arrayList);


    }
}
