package chapter3;

import static net.mindview.util.Print.*;

import java.util.Date;
import java.util.Random;

public class Practise9
{

    public static void main(String[] args)
    {
        float f = Float.MIN_VALUE;
        print("float min is:" + Float.MIN_VALUE);
        print("float min is:" + String.format("%.50f", f));
        print("float max is:" + Float.MAX_VALUE);
        print("double min is:" + Double.MIN_VALUE);
        print("double min is:" + Double.MAX_VALUE);
    }
}
