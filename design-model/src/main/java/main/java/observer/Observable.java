package main.java.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzc
 * @date 2020/7/28 13:46
 * @desc 被观察者，我们称它为Observable，即可以被观察的东西，有时候还会称之为主题，即Subject
 */
public class Observable<T> {
    List<Observer<T>> mObservers = new ArrayList<Observer<T>>();


    public void register(Observer<T> observer) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            if (!mObservers.contains(observer))
                mObservers.add(observer);
        }
    }

    public synchronized void unregister(Observer<T> observer) {
        mObservers.remove(observer);
    }

    //下发通知
    public void notifyObservers(T data) {
        for (Observer<T> observer : mObservers) {
            observer.onUpdate(this, data);
        }
    }

}
