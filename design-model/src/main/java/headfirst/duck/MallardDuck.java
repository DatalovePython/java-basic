package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 16:40
 * @desc 绿头鸭
 *
 *
 * 绿头鸭使用Quack类处理呱呱叫，所以当performQuack()被调用时，
 * 叫的职责被委托给Quack对象，而我们得到了真正的呱呱叫。
 * 使用FlyWithWings作为其FlyBehavior类型
 */
public class MallardDuck extends Duck {

    //因为MallardDuck继承Duck类，所以具有
    //flyBehavior 与 quackBehavior 实例变量。
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I’m a real Mallard duck");
    }


}
