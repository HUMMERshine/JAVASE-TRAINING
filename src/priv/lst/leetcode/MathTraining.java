package priv.lst.leetcode;

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
	
	//8
	@Test
	public void stringToInteger(){
		int n = Integer.MAX_VALUE;
		n = n + 1;
		System.out.println(n);
	}
}
