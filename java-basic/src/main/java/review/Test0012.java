package review;

/**
 * @author luzc
 * @date 2020/9/2 16:04
 * @desc
 *
 * 打印结果：
 *
 * a:AB
 * b:B
 * c:c
 * d:d
 *  两个问题
 * 为什么c,d 没有变，a却有变？
 * 为什么a变了，b却没有变化？
 */
public class Test0012 {
    private void stringBufferChange(StringBuffer a, StringBuffer b){
        a.append(b);
        b=a;
    }

    private void stringChange(String a,String b){
        a = a + b;
        b = a;
    }

    public static void main(String[] args) {
        Test0012 t = new Test0012();
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        String c = "c";
        String d = "d";

        char[] chars= {'a','c'};
        String s = new String(chars);
        String zz = "ac";

        t.stringBufferChange(a, b);
        t.stringChange(c,d);
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        System.out.println("c:"+c);
        System.out.println("d:"+d);
    }

}
