package chapter3;

import static net.mindview.util.Print.*;

import java.util.Date;
import java.util.Random;

public class Practise10
{

    public static void main(String[] args)
    {
        int x = 0xaaaa;
        int y = 0x5555;
        print(Integer.toBinaryString(x&y));
        print(Integer.toBinaryString(x|y));
        print(Integer.toBinaryString(x));
        print(Integer.toBinaryString(y));
        print(Integer.toBinaryString(x^y));
        print(Integer.toBinaryString(x|x));
        print(Integer.toBinaryString(x&x));
        print(Integer.toBinaryString(x^x));
        print(Integer.toBinaryString(~x));



    }
}
