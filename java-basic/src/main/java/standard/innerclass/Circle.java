package standard.innerclass;

import com.sun.org.apache.xpath.internal.objects.XNumber;

/**
 * @author luzc
 * @date 2020/9/7 9:30
 * @desc 参考连接：https://www.cnblogs.com/dolphin0520/p/3811445.html
 */
public class Circle {
    private double radius = 0;
    private static int count = 1;
    private int number = 1;

    public Circle(double radius) {
        this.radius = radius;
        getInstance().drawShape();

    }


    private Draw getInstance(){
        return new Draw();
    }

    //todo：成员内部类,类似一个类的成员变量
    class Draw {

        public void drawShape() {

            int number = 1;
            System.out.println(radius); //外部类的private成员
            System.out.println(count); //外部类的静态成员
            // 当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，
            // 即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问
            System.out.println(Circle.this.number);
        }
    }

    //静态内部类
    static class Inner{
        public Inner(){
            //只能访问外部类的静态变量
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(1);
        //创建内部类的方式
        Draw draw = circle.new Draw();
        //方式二
        Draw instance = circle.getInstance();
    }

}


// todo: 局部内部类
class People{
    public People() {

    }
}

class Man{

    int age = 1;
    final int number = 1;
    public void printAge(){
        System.out.println(age);
    }
    public Man(){

    }

    public People getWoman(){
        // 局部内部类就像是方法里面的一个局部变量一样，
        // 是不能有 public、protected、private 以及 static 修饰符的。
        class Woman extends People{   //局部内部类
            private void test(){
                //为什么局部内部类和匿名内部类只能访问局部final变量？

                System.out.println(number);
            }
//            int age =0;

        }
        return new Woman();
    }
}

//todo: 匿名内部类
// 我在安卓开发中经常使用，事件监听事件，用的就是匿名内部类，
// new View.OnclickListener(){
//  @Override
//    public void onClick(View v) {
//        // TODO Auto-generated method stub
//
//    }
//
// }
/*
*
* 同样的，匿名内部类也是不能有访问修饰符和 static 修饰符的。
* 匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。
* 匿名内部类在编译的时候由系统自动起名为 Outter$1.class。
* 一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。
* */


