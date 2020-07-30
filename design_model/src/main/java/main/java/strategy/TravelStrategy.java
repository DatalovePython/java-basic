package main.java.strategy;

/**
 * @author luzc
 * @date 2020/7/30 14:21
 * @desc 策略模式定义了一些列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。策略模式让算法独立于使用它的客户而独立变换。
 *
 *
 * 假设我们要出去旅游，而去旅游出行的方式有很多，有步行，有坐火车，有坐飞机等等。而如果不使用任何模式，我们的代码可能就是这样子的。
 *
 * 这样做有一个致命的缺点，一旦出行的方式要增加，我们就不得不增加新的else if语句，而这违反了面向对象的原则之一，对修改封闭。
 * 而这时候，策略模式则可以完美的解决这一切。
 */
public class TravelStrategy {
    //枚举类本身就是单例模式，一次初始化全程使用
    enum Strategy{
        WALK,PLANE,SUBWAY
    }
    private Strategy strategy;
    public TravelStrategy(Strategy strategy){
        this.strategy=strategy;
    }

    public void travel(){
        if(strategy==Strategy.WALK){
            print("walk");
        }else if(strategy==Strategy.PLANE){
            print("plane");
        }else if(strategy==Strategy.SUBWAY){
            print("subway");
        }
    }

    public void print(String str){
        System.out.println("出行旅游的方式为："+str);
    }

    public static void main(String[] args) {
        TravelStrategy walk=new TravelStrategy(Strategy.WALK);
        walk.travel();

        TravelStrategy plane=new TravelStrategy(Strategy.PLANE);
        plane.travel();

        TravelStrategy subway=new TravelStrategy(Strategy.SUBWAY);
        subway.travel();
    }
}
