package priv.lst.tij.chapter3;

import static net.mindview.util.Print.*;

import java.util.Date;
import java.util.Random;

public class Practise14
{

    public static void p(String s, boolean b)
    {
        System.out.println(s + ": " + b);
    }

    public static void compare(String lval, String rval)
    {
        System.out.println("lval: " + lval + " rval: " + rval);
        // ! p("lval < rval: " + lval < rval);
        // ! p("lval > rval: " + lval > rval);
        // ! p("lval <= rval: "
        // ! p("lval >= rval: "
        p("lval == rval", lval == rval);
        p("lval != rval", lval != rval);
        p("lval.equals(rval)", lval.equals(rval));
    }

    public static void main(String[] args)
    {
        String s1 = "Hello";
        compare(s1, "Hello");
        compare("Hello", "Hello");
        // Force creation of separate object:
        String s = new String("Hello");
        String s2= new String("Hello");
        compare("Hello", s);
        compare("Hello", "Goodbye");
        compare(s, s2);
        
//        char [] ch = new char[1];
//        print(ch.toString());
    }
}
