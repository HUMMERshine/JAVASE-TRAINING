package priv.lst.tij.chapter10;

public class Practise1
{
    class Inner
    {

    }

    public Inner test()
    {
        return new Inner();
    }

    public static void main (String [] args)
    {
        //Practise1.Inner x = new Practise1.Inner();
        Practise1 p = new Practise1();
        Inner ddd = p.test();
    }
}
