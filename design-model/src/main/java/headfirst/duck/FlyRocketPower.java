package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 17:22
 * @desc
 */
public class FlyRocketPower implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i'm flying with rocket");
    }
}
