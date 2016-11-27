package chapter5;

public class Practice10
{
    public static void main(String [] args)
    {
        Practice10 practice10 = new Practice10();
        new Practice10();
        //Thread.sleep(10000);
        System.gc();
    }
    
    @Override
    protected void finalize() throws Throwable
    {
        // TODO Auto-generated method stub
        super.finalize();
        System.out.println("this is finalize");
    }
}
