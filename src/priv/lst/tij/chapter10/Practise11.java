package priv.lst.tij.chapter10;

interface A
{

}

class Outer2
{
    private class Inner implements A
    {

    }
    
    public A get()
    {
        return new Inner();
    }
    
    public Inner get2()
    {
        return new Inner();
    }
}

public class Practise11
{
    public static void main(String[] args)
    {
        Outer2 outer = new Outer2();
        A in = outer.get();
        A in2 = outer.get2();
        //(Inner) in;
    }
    
}
