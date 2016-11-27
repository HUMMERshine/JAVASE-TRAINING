package chapter3;

import static net.mindview.util.Print.*;

import java.util.Date;

public class Practise3
{
    public static void main(String[] args)
    {
        float f1 =1;
        float f2;
        
        f2 = f1;
        
        f2++;
        
        print("f1=" + f1 + "\nf2=" + f2);
    
        MyFloat f3 = new MyFloat();
        MyFloat f4 = new MyFloat();
        f3.f = 10;
        f4 = f3;
        f3.f++;
        print("f3=" +f3.f +"\nf4=" + f4.f);
        
        MyFloat f5 = new MyFloat();
        f5.f = f3.f;
        f3.f++;
        print("f3=" +f3.f +"\nf5=" + f5.f);
    }
}

class MyFloat
{
    public float f;
}