package review;

/**
 * @author luzc
 * @date 2020/8/27 15:00
 * @desc 在catch处直接return的后果
 */

public class Test0005
{
    public static String output = "";
    public static void foo(int i)
    {
        try
        {
            if (i == 1)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            output += "2";
            return ;
        } finally
        {
            output += "3";
        }
        output +="4";
    }
    public static void main(String[] args)
    {
        foo(0);
        foo(1);
        System.out.println(output);
    }
}
