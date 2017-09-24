package priv.lst.leetcod;

import org.junit.Test;

public class Bit {
	
	public static void main(String[] args) {
		new Bit().reverseBits(1);
		System.out.println(Math.sqrt(7));
	}
	
	public int reverseBits(long n) {
		n = 1 ;
        String s = Long.toBinaryString(n);
        long k = 1;
        long result = 0;
        int temp = 0;
        
        if(s.length() < 32){
        	int t = 32 - s.length();
        	while(t-- != 0){
        		k = k * 2;
        	}
        }else{
        	temp = s.length() - 32;
        }
        for(int i = temp; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                result = result + k;   
            }
            k = k * 2;
        }
        
        System.out.println(result);
        return (int)result;
    }
	
	public void prac318(){
		int i = 0;
		char ch = 'c';
		
		int result = ch - 'a';
		
		i = 1 << result;
		
		boolean x =  (i | result) == 0;//==优先级比&|^高但比！低
	}
	
	@Test
	public void pracx(){
		int i = -1;
		//int k = i >>> 28;
		System.out.println(i >>> 28);
		int k;
		k = i >>> 28;
		int a = k & 15;
		System.out.println(a);
		//System.out.println(k & 15);
		short s = 3;
		int m = 3;
		long l = 3;

		System.out.println(s >> 32);
		System.out.println(m >> 32);
		System.out.println(l >> 32);
	}
}
