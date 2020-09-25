package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 16:37
 * @desc
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quakc");
    }
}
