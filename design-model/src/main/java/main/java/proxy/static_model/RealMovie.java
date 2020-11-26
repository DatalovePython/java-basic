package main.java.proxy.static_model;

/**
 * @author luzc
 * @date 2020/11/26 15:33
 * @desc    然后，我们要有一个真正的实现这个 Movie 接口的类，和一个只是实现接口的代理类。
 */
public class RealMovie implements Movie{


    @Override
    public void play() {
        System.out.println("您正常在看 《《肖申克的救赎》》");
    }
}
