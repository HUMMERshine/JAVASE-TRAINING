package chapter3;

import static net.mindview.util.Print.*;

import java.util.Date;
import java.util.Random;

public class Practise7
{

    public static void main(String[] args)
    {
        Random random = new Random();
        for (int i = 0; i < 100; i++)
        {
            Boolean result = random.nextBoolean();
            print(result);
            print("coin is :" + (result ? "HEAD" : "TAIL"));
        }
    }
}
