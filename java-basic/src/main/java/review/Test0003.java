package review;

/**
 * @author luzc
 * @date 2020/8/27 11:11
 * @desc 方法重载
 *
 * 重写的条件
 * 两同:方法名、形参列表相同；
 * 两小:返回值类型、抛出异常更小，这里的“小”指的是继承关系的子父类，不是像高赞所谓的float和int的大小之分；
 * 一大:访问修饰符。
 */
public class Test0003 {

}

class Parent{
    public float aFun(float a,float b){
        return 1;
    }
}

class Child extends Parent{


//    方法重写(覆盖)。子类方法不能缩小父类方法的访问权限，错误。
//    float aFun(float a,float b){
//        return 1;
//    }

//    方法重载。参数列表不同，满足重载条件，正确。
//    public int aFun(int a, int b) {
//        return 1;
//    }

//    方法重写(覆盖)。方法声明和父类相同，满足重写条件，正确。
    public float aFun(float  p,  float q){
        return 1;
    }

//    方法重载。参数列表不同，满足重载条件，正确。
//    private int aFun(int a,  int  b){
//        return 2;
//    }
}
