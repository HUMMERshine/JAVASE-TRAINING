package priv.lst.tij.chapter5;

import static net.mindview.util.Print.*;

import java.util.Arrays;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Practisefive
{
    String strTest;

    @Test
    public void practice1()
    {
        String str2 = null;
        if (strTest == null)
        {
            print("true");
        }
        if (str2 == null)
        {

        }
    }

    static String string1 = "first static string";
    static String string2;
    static
    {
        string2 = "second static string";
        String string3 = "不可以定义。";
    }

    static void printStatic()
    {
        System.out.println("string1: " + string1 + "\nstring2 :" + string2);
    }

    @Test
    public void practice14()
    {
        System.out.println("string1 and string2 are printed above.");
    }

    public static void main(String[] args)
    {
        new Practisefive().practice14();
        new Practisefive().practice19("1111", "22222", "3333");
    }

    @Test
    public void practice16()
    {
        String[] str = new String[4];
        str[0] = "first";
        str[1] = "second";
        str[2] = "third";
        str[3] = "firth";
        for (int i = 0; i < str.length; i++)
        {
            System.out.print(str[i] + " ");
        }
    }

    @Test
    public void practice18()
    {
        class Test
        {
            Test(String s)
            {
                System.out.println("constructor");
            }
        }
        Test[] test = new Test[5];

        test[0] = new Test("hello");

    }

    public void practice19(String... string)
    {
        System.out.println(string.length);
        for (String s : string)
        {
            print(s);
        }
    }
@Test
    public void practice21()
    {
        for(Money money : Money.values())
        {
            System.out.println(money + " " + money.ordinal());
            switchDemo(money);
        }
        
    }
    public void switchDemo(Money mon)
    {
        switch(mon){
            case YIYUAN:
                print("这是一块钱");
                break;
            case ERYUAN:
                print("这是二块钱");
                break;
            case WUYUAN:
                print("这是五块钱");
                break;
            case SHIYUAN:
                print("这是十块钱");
                break;
            case ERSHIYUAN:
                print("这是二十块钱");
                break;
            case WUSHIYUAN:
                print("这是五十块钱");
                break;
        }
    }
    
    enum Money
    {
        YIYUAN, ERYUAN, WUYUAN, SHIYUAN, ERSHIYUAN, WUSHIYUAN
    }
}
