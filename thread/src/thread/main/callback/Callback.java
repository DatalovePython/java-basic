package thread.main.callback;

/**
 * @author luzc
 * @date 2020/8/5 10:38
 * @desc 首先需要一个接口callback，以及一个继承了接口的类Teacher。
 * Teacher类中有另一个类Student的对象，在Teacher中执行函数，会调用student中的方法，
 * student执行对应方法后再回调Teacher中重写的接口方法，这样就完成了一次回调方法。
 *
 */
public interface Callback {
    public void tellAnswer(int answer);

}
