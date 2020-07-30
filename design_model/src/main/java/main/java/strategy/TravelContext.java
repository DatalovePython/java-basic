package main.java.strategy;

/**
 * @author luzc
 * @date 2020/7/30 14:46
 * @desc 此外还需要一个包装策略的类，并调用策略接口中的方法
 */
public class TravelContext {
    Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void travel() {
        if (strategy != null) {
            strategy.travel();
        }
    }
}
