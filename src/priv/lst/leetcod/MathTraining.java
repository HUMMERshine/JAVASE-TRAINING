package priv.lst.leetcod;

import org.junit.Test;

public class MathTraining {

	@Test
	public void train7() {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		System.out.println(max);
		System.out.println(max + 1);
		System.out.println(min);
		System.out.println(min - 1);
	}

	public static void main(String[] args) {
		new MathTraining().numberofbit();
	}

	public static int numberofbit() {
		int n = 2;
		int count = 0;
		while (n != 0) {
			if (n % 2 == 1) {
				count++;
			}

			n = n / 2;
		}
		System.out.println(count);
		return count;
	}

	// 8
	@Test
	public void stringToInteger() {
		int n = Integer.MAX_VALUE;
		n = n + 1;
		System.out.println(n);
	}

	// 60
	@Test
	public void getPermutation() {
		int[] array = new int[9];
		int k = 4;
		int n = 3;
		array[0] = 1;
		for (int i = 1; i < 9; i++) {
			array[i] = array[i - 1] * (i + 1);
		}

		String s = "";
		for (int i = 2; i <= n; i++) {
			s = s + (k / array[n - i] + 1);
			k = k % array[n - i];
		}
		System.out.println(s);
	}
	
	public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 0) return Integer.MAX_VALUE;
        
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        int mul = 0;
        
        if(ldivisor < ldividend) return 0;
        if(ldivisor == ldividend){
            mul = 1;
        }else{
            while(ldivisor <= ldividend){
                long n = ldivisor;
                int tmul = 1;
                while((n << 1) < ldividend){
                    tmul =  tmul << 1;
                    n = n << 1;
                }
                ldividend -= n;
                mul += tmul;
            }
        }
        
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0){
            return 0 - mul;
        }
        return mul;
        
    }
	
	@Test
	public void number(){
		int a = 0x13;
		char x = 'x';
		
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toHexString(a));
		System.out.println(Integer.toOctalString(a));
		System.out.println(false ? 1111111111 : 'x');
		System.out.println('a' + 12);
	}
	
}
