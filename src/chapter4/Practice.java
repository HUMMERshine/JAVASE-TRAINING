package chapter4;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static net.mindview.util.Print.*;

public class Practice
{
    Random random = new Random(47);

    // @Before
    @Test
    public void practice1()
    {
        int x = 0;
        for (int i = 1; x < 100; i++)
        {
            for (int j = 0; j < i && x < 100; j++)
                System.out.print(x++ + "    ");
            System.out.println();
        }
    }

    @Test
    public void practice2()
    {
        // for (int i = 0; i < 25; i++)
        while (true)
        {
            int a = random.nextInt();
            int b = random.nextInt();

            print("a=" + a + "b=" + b);
            if (a > b)
            {
                print("a > b");
            }
            else if (a < b)
            {
                print("a < b");
            }
            else
            {
                print("a = b");
            }
        }
    }

    @Test
    public void practice4()
    {
        boolean flag;
        for (int i = 2; i < 100; i++)
        {
            flag = true;
            for (int j = 2; j < i; j++)
            {
                if (i % j == 0)
                {
                    flag = false;
                }
            }
            if (flag)
            {
                print(i + "是素数");
            }
        }
    }

    public String toBinaryString(int i)
    {
        char[] buffer = new char[32];
        for (int k = 31; k >= 0; k--)
            buffer[k] = ((i & 0x01) != 0 ? '1' : '0');
        return String.valueOf(buffer);
    }

    @Test
    public void practice5()
    {
        int x = 0xaaaa;
        int y = 0x5555;
        System.out.println("x & y=" + toBinaryString(x & y));
        print("x | y=" + toBinaryString(x | y));
        print("x=" + toBinaryString(x));
        print("y=" + toBinaryString(y));
        print("x ^ y=" + toBinaryString(x ^ y));
        print("x | x=" + toBinaryString(x | x));
        print("x & x=" + toBinaryString(x & x));
        print("x ^ x=" + toBinaryString(x ^ x));
        print("~x=" + toBinaryString(~x));
    }

    public void fibonacci(int x)
    {
        // 也可以用递归实现fibonacci(i-1) + fibonacci(i-2);if(x<3) return 1;
        int i = 0, j = 0, temp = 0;
        for (int k = 1; k <= x; k++)
        {
            if (k == 1)
            {
                i = 1;
                System.out.print(i + " ");
            }
            else if (k == 2)
            {
                j = 1;
                System.out.print(j + " ");
            }
            else
            {
                temp = i + j;
                i = j;
                j = temp;
                System.out.print(j + " ");
            }
        }
    }

    @Test
    public void practice9()
    {
        for (int i = 1; i < 10; i++)
        {
            fibonacci(i);
            print();
        }
    }

    @Test
    public void practice10()
    {
        for (int i = 11; i < 100; i++)
        {
            for (int j = i; j < 100; j++)
            {
                int result = i * j;
                String str1 = Integer.toString(i);
                String str2 = Integer.toString(j);
                
                char [] buff1 = (str1+str2).toCharArray();
                char [] buff2 = (Integer.toString(result)).toCharArray();
                if(buff2.length != 4)
                    continue;
                
                Arrays.sort(buff1);
                Arrays.sort(buff2);
                boolean isVampire = Arrays.equals(buff1, buff2);
                if (isVampire)
                {
                    System.out.println(i + " * " + j + " = " + result);
                }
            }
        }
    }

    public static void main(String[] args)
    {
    }
}
