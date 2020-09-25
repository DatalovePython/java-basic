package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 17:20
 * @desc
 */
public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("i'm a model(模型）鸭子");
    }
}
