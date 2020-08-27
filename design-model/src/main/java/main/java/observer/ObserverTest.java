package main.java.observer;

/**
 * @author luzc
 * @date 2020/7/28 13:47
 * @desc 观察上面两个情景，有一个共同点，就是我们无需每时每刻关注我们感兴趣的东西，
 * 我们只需做的就是订阅感兴趣的事物，比如天气预报服务，杂志等，
 * 一旦我们订阅的事物发生变化，比如有新的天气预报信息，新的杂志等，被订阅的事物就会即时通知到订阅者，即我们。
 * 而这些被订阅的事物可以拥有多个订阅者，也就是一对多的关系。当然，严格意义上讲，
 * 这个一对多可以包含一对一，因为一对一是一对多的特例，没有特殊说明，本文的一对多包含了一对一。
 */
public class ObserverTest {
    public static void main(String [] args){
        Observable<Weather> observable=new Observable<Weather>();
        Observer<Weather> observer1=new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                System.out.println("观察者1："+data.toString());
            }
        };
        Observer<Weather> observer2=new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {
                System.out.println("观察者2："+data.toString());
            }
        };

        observable.register(observer1);
        observable.register(observer2);


        Weather weather=new Weather("晴转多云");
        observable.notifyObservers(weather);

        Weather weather1=new Weather("多云转阴");
        observable.notifyObservers(weather1);

        observable.unregister(observer1);

        Weather weather2=new Weather("台风");
        observable.notifyObservers(weather2);

    }
}
