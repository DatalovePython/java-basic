package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 16:35
 * @desc
 * 这是飞行行为的实现，给不会飞的鸭子用
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i can't fly");
    }
}
