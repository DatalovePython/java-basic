package gc;

/**
 * @author luzc
 * @date 2021/4/1 14:30
 * @desc
 */
public class M {
    // 当被回收时被调用
    @Override
    public void finalize(){
        System.out.println("finalize");
    }
}
