package main.java.proxy.dynamic_model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author luzc
 * @date 2020/11/26 15:51
 * @desc
 */
public class DynamicProxy {
    public static void main(String[] args) {

        Maotaijiu maotaijiu = new Maotaijiu();
        Wuliangye wuliangye = new Wuliangye();
        Furongwang furongwang = new Furongwang();

        InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);
        InvocationHandler jingxiao2 = new GuitaiA(wuliangye);
        InvocationHandler jingxiao3 = new GuitaiA(furongwang);

        SellWine dynamicProxy = (SellWine)Proxy.newProxyInstance(Maotaijiu.class.getClassLoader(),
                Maotaijiu.class.getInterfaces(), jingxiao1);

        SellWine dynamicProxy2 = (SellWine)Proxy.newProxyInstance(Wuliangye.class.getClassLoader(),
                Wuliangye.class.getInterfaces(), jingxiao2);

        SellCigarette dynamicProxy3 = (SellCigarette)Proxy.newProxyInstance(Furongwang.class.getClassLoader(),
                Furongwang.class.getInterfaces(),jingxiao3);

        dynamicProxy.mainJiu();
        dynamicProxy2.mainJiu();
        dynamicProxy3.sell();
    }
}
