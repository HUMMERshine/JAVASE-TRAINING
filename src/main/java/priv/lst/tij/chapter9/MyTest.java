package priv.lst.tij.chapter9;

import org.junit.Test;

interface InterfaceDemo
{
    String string = "final static";
}

abstract class AbstractDemo
{
    public String string = "final";
}

public class MyTest implements InterfaceDemo
{
    @Test
    public void print()
    {
        System.out.println(string);
    }
}