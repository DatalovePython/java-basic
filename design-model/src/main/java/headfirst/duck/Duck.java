package headfirst.duck;

/**
 * @author luzc
 * @date 2020/9/25 16:24
 * @desc  面向抽象编程，正是策略模式
 * 策略模式定义了算法族，使他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户
 */
public abstract class Duck {

    //为行为接口类型声明两个引用变量，所有鸭子子类（在同一个package）中，都继承他们。
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck(){

    };

    public abstract void display();


    //委托给行为类
    public void performFly(){
        flyBehavior.fly();
    };

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("every ducks float,even decoys");
    }

    //随时通过调用这两个方法，来改变鸭子的行为。
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }
}
