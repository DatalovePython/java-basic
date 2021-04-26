package test;

/**
 * @author luzc
 * @date 2020/8/17 15:24
 * @desc
 */

import java.time.LocalDateTime;

public class lang {


    protected String a;

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);
        int todayOfWeek = currentTime.getDayOfWeek().getValue();
        System.out.println(todayOfWeek);



    }


}


