package thread.main.callback;

/**
 * @author luzc
 * @date 2020/8/5 10:20
 * @desc
 */

public class Student {

    public void resolveQuestion(Callback callback, final String question){

        System.out.println("Student receive the question: " + question);    //学生收到老师的问题
        System.out.println("Student: I am busy");
        doSomething();                                       //学生在忙其他的事
        callback.tellAnswer(2);                    //忙完之后回答问题
    }

    public void doSomething(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
