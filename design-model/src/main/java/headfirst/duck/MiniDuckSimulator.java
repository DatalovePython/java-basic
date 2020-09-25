package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 16:39
 * @desc
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        /*
        *   这会调用MallardDuck继承来的
            performQuack()方法，进而委托给该对
            象的QuackBehavior对象处理（也就是说，
            调用继承来的quackBehavior引用对象的
            quack()）。
        * */
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        ModelDuck modelDuck = new ModelDuck();
        /*
        第一次调用performFly() 会被委托给
        flyBehavior对象（也就是FlyNoWay实
        例），该对象是在模型鸭构造器中设
        置的。
        * */
        modelDuck.performFly();
        /*  意味着模型鸭可以动态地
            改变它的飞行行为。如果把行为的实现绑
            死在鸭子类中，可就无法做到这样了。*/
        modelDuck.setFlyBehavior(new FlyRocketPower());
        modelDuck.performFly();
    }
}
