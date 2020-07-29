package main.java.observer;

/**
 * @author luzc
 * @date 2020/7/28 13:46
 * @desc
 */
public interface Observer<T> {
    void onUpdate(Observable<T> observable,T data);
}
