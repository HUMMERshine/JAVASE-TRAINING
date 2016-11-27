package chapter8;

class Father
{
    public String what()
    {
        return "fatherchich";
    }

    @Override
    public String toString()
    {
        // TODO Auto-generated method stub
        return this.what();
    }
}

public class Practice6 extends Father
{
    public String what()
    {
        return "child";
    }

    public static void main(String[] args)
    {
        System.out.println(new Practice6());
    }
}
