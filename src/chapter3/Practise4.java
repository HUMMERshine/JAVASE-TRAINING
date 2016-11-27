package chapter3;

import static net.mindview.util.Print.*;

import java.util.Date;

public class Practise4
{
    public static void main(String[] args)
    {
        if(args.length < 2)
        {
            System.out.println("parameter must be 2");
            System.exit(1);
        }
        float distance = Float.parseFloat(args[0]);
        float time = Float.parseFloat(args[1]);

        print("distance/time=" + distance/time);
    }
}
