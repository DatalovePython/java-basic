package standard.innerclass;

/**
 * @author luzc
 * @date 2020/9/7 10:29
 * @desc
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }

    public void test(){
        int a = 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(a);
            }
        }).start();


        new Thread(){
          public void run(){
              System.out.println(a);
          }
        }.start();


    }

}
