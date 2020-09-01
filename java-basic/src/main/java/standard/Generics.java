package standard;

/**
 * @author luzc
 * @date 2020/8/24 13:54
 * @desc 泛型的基础使用
 */
public class Generics {
    public static void main(String[] args){
        // 实例化泛型类
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        int x = p1.getX();
        int y = p1.getY();
        System.out.println("This point is：" + x + ", " + y);

        Point<Double, String> p2 = new Point<Double, String>();
        p2.setX(25.4);
        p2.setY("东京180度");
        double m = p2.getX();
        String n = p2.getY();
        System.out.println("This point is：" + m + ", " + n);

        //泛型擦除
        Point p3 = new Point();  // 类型擦除
        p3.setX(10);
        p3.setY(20.8);
        int x3 = (Integer)p3.getX();  // 向下转型
        double y3 = (Double)p3.getY();
        System.out.println("This point is：" + x3 + ", " + y3);
    }
}

// 定义泛型类
class Point<T1, T2>{
    T1 x;
    T2 y;
    public T1 getX() {
        return x;
    }
    public void setX(T1 x) {
        this.x = x;
    }
    public T2 getY() {
        return y;
    }
    public void setY(T2 y) {
        this.y = y;
    }

    // 定义泛型方法
    public <T1, T2> void printPoint(T1 x, T2 y){
        T1 m = x;
        T2 n = y;
        System.out.println("This point is：" + m + ", " + n);
    }

    //通过 extends 关键字可以限制泛型的类型
    public <T extends Number> T getMax(T array[]){
        T max = null;
        for(T element : array){
            max = element.doubleValue() > max.doubleValue() ? element : max;
        }
        return max;
    }
}

//定义泛型接口
interface Info<T> {
    public T getVar();
}

//实现接口
class InfoImp<T> implements Info<T> {
    private T var;

    // 定义泛型构造方法
    public InfoImp(T var) {
        this.setVar(var);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }
}
