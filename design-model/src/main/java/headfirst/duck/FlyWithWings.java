package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 16:34
 * @desc
 *
 * 这是飞行行为的实现，给”真正"会飞的鸭子用
 */
public class FlyWithWings implements FlyBehavior {


    @Override
    public void fly() {
        System.out.println("i am flying");
    }
}
