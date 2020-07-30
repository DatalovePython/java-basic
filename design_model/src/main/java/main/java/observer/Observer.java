package main.java.observer;

/**
 * @author luzc
 * @date 2020/7/28 13:46
 * @desc 观察者，我们称它为Observer，有时候我们也称它为订阅者，即Subscriber
 */
public interface Observer<T> {

    void onUpdate(Observable<T> observable,T data);
}
