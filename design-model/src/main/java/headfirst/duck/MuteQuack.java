package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 16:38
 * @desc
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<silence>>");
    }
}
