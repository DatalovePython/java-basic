package standard;

/**
 * @author luzc
 * @date 2020/8/14 15:13
 * @desc
 * 使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无
 * 内容的检查，否则会有抛 IndexOutOfBoundsException 的风险。
 */
public class StringSplit {

    public static void main(String[] args) {
        String str = "a,,c";
        String[] arr = str.split(",");
        System.out.println(arr.length);

    }
}
