package main.java.proxy.dynamic_model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author luzc
 * @date 2020/11/26 15:48
 * @desc
 */
public class GuitaiA implements InvocationHandler {

    private Object pingpai;

    public GuitaiA(Object pingpai) {
        this.pingpai = pingpai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("销售开始 柜台是：" + this.getClass().getSimpleName());
        method.invoke(pingpai, args);
        System.out.println("销售结束");
        return null;

    }
}
