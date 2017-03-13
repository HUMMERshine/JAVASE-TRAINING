package priv.lst.demo;

import java.util.Arrays;

public class DemoTest {

	public static void main(String[] args) {
		char [] a = {'a', 'b', 'c'};
		
		System.out.println(Arrays.toString(a));
		new DemoTest().reverse(1534236469);
	}
public int reverse(int x) {
        
        int result = 0;
        boolean flag = false;        
        if(x < 0)
        {
            flag = true;
            x = 0-x;
            if(x < 0)//防止x是MIN_VALUE；
            {
                return 0;
            }
        }
        
        while(x != 0)
        {
        	if((Integer.MAX_VALUE - x % 10) / 10 < result) //溢出了
            {
                return 0;
            }
            result = result * 10 + x % 10;
            System.out.println("*****" + result);
            
            x = x / 10;
        }
        
        if(flag)
        {
            result = 0 - result; 
        }
        
        return result;
    }
}
