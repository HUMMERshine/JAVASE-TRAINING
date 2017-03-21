package priv.lst.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoTest {

	public static void main(String[] args) {
		Byte k = 127;
		System.out.println(k++);
		char [] a = {'a', 'b', 'c'};
		
		System.out.println(Arrays.toString(a));
		new DemoTest().reverse(1534236469);
		
		List<Integer> list = new ArrayList<>();
		list.add(null);
		System.out.println(list.size());
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
