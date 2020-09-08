package test;

/**
 * @author luzc
 * @date 2020/8/17 15:24
 * @desc
 */

import java.io.Console;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class lang {

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }


}


