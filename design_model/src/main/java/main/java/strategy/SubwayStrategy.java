package main.java.strategy;

/**
 * @author luzc
 * @date 2020/7/30 14:45
 * @desc 然后根据不同的出行方式实行对应的接口
 */
public class SubwayStrategy implements Strategy{

    @Override
    public void travel() {
        System.out.println("subway");
    }

}
