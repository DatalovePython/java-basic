package stringpool;

/**
 * @author luzc
 * @date 2021/3/22 9:59
 * @desc
 * intern() 运行时常量池中，如果有该变量，则直接引入，没得话则新建并加入
 */
public class StringPool58Demo {


    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }
}
