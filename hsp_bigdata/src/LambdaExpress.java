// 用来检验 接口中是否只有一个抽象方法 jdk1.8新特性
//接口默认继承java.lang.Object，所以如果接口显示声明覆盖了Object中方法
@FunctionalInterface
interface Foo{
    public int add(int x,int y);

    //java.lang.object 中的方法不是抽象方法
    public boolean equals(Object var1);
    //default 方法可以定义多个
    default int mul(int x,int y){
        return x*y;
    }

    public static int div(int x,int y){
        return x/y;
    }
}
/*
1： 语法，拷贝小括号，写死右箭头，落地大括号
2： @FunctionalInterface
3:  default
4;  static
 */

public class LambdaExpress {
    public static void main(String[] args) {
        Foo foo = (int x,int y) -> {
            System.out.println("come in the method");
            return x + y;
        };
        System.out.println(foo.add(3,55));
        System.out.println(foo.mul(3,5));
        System.out.println(Foo.div(10, 2));
    }
}
