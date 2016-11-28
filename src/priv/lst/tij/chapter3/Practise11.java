package priv.lst.tij.chapter3;

import static net.mindview.util.Print.*;

import java.util.Date;
import java.util.Random;

public class Practise11
{

    public static void main(String[] args)
    {
        int x = Integer.MIN_VALUE;
        print(Integer.toBinaryString(x));
        for(int i=0;i<10;i++)
            print("show = " + Integer.toBinaryString(x>>=1));
        for(int i=0;i<10;i++)
            print("show = " + Integer.toBinaryString(x>>>=1));

        x = -1;
        x <<= 1;
        print(Integer.toBinaryString(x));
        for(int i=0;i<32;i++)
            print("show = " + Integer.toBinaryString(x>>>=1));
        
        print(Integer.toBinaryString('a'));
        int i, y;
        for (i = 0, y = 'a'; y!='z'; i++,y++);
        print(i);
        {
            
        }
    }
}
