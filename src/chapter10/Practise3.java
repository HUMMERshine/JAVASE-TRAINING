package chapter10;

/**
 * <P>
 * @ClassName:Outer
 * </p>
 * <P>
 * @Description:TODO
 * </p>
 * <P>
 * @author:
 * </p>
 * <P>
 * @date:2016年7月6日 下午1:22:23
 * </p>
 */
class Outer1
{
    class Inner
    {

    }

    public Inner test()
    {
        return new Inner();
    }

}

public class Practise3
{
    public static void main(String[] args)
    {
        // Practise1.Inner x = new Practise1.Inner();
        Outer1 outer = new Outer1();
        Outer1.Inner ddd = outer.test();
        Outer1.Inner xx = outer.new Inner();// 在外部，创建内部类，需要引用外部类的对象
    }
}
