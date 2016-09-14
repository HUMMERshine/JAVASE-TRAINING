package priv.lst.leetcode;

import org.junit.Test;

public class Bit {
	
	public static void main(String[] args) {
		new Bit().reverseBits(1);
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
}
