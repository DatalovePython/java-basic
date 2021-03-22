package thread.main.callback;

/**
 * @author luzc
 * @date 2020/8/5 10:39
 * @desc Android中也使用了很多的回调机制，最常见的一个就是onClickListener，还有handle等，其实都是一个个的回调机制
 */

public class Teacher implements Callback {
    private Student student;

    public Teacher(Student student){
        this.student = student;
    }

    public void askQuestionSync(final String question){
        System.out.println("Teacher ask a question sync(同步): "+ question);    //提出一个问题
        student.resolveQuestion(this,question);                      //询问学生
        System.out.println("Teacher: do something else");             //忙自己的事
    }

    public void askQuestionAsync(final String question){
        System.out.println("Teacher ask a question async（异步）: "+ question);
        new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                student.resolveQuestion(Teacher.this,question);              //这里需要注意必须声明是Teacher.this

            }

        }).start();
        System.out.println("Teacher: do something else");
    }

    @Override              //重写回调函数
    public void tellAnswer(int answer){
        System.out.println("your answer is: " + answer);
    }

    //测试回调事件
    public static void main(String[] args) {
        Student st = new Student();
        Teacher th = new Teacher(st);
        th.askQuestionSync("1+1=?");
        System.out.println("》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
        th.askQuestionAsync("1+1=?");

    }

}
