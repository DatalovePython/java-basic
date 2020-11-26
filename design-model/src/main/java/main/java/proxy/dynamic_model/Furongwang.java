package main.java.proxy.dynamic_model;

/**
 * @author luzc
 * @date 2020/11/26 16:12
 * @desc
 */
public class Furongwang implements SellCigarette {
    @Override
    public void sell() {
        System.out.println("卖芙蓉王");
    }
}
