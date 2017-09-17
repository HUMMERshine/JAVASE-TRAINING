package priv.lst.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

class A{
	
}
class B extends A{
	
}
class C extends A{
	
}
public class Main {

	private static int res = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		long n = scanner.nextInt();
		
		backtrace(1, 0, n);
		System.out.println(res);
	}
	
	public static void backtrace(long index, long sum, long n){
		if(sum == n){
			res++;
			return;
		}
		if(sum > n || index > n) return;
		
		backtrace(index * 2, sum, n);
		backtrace(index * 2, sum + index, n);
		backtrace(index * 2, sum + index * 2, n);
	}

	@Test
	public static void calculate() {
		int [] persons = new int[10];
		Random random = new Random();
		long time = System.currentTimeMillis();
		if(System.currentTimeMillis() - time < 45000){
			Thread.sleep(1000);
		}
		
		int i = 0;
		while(i < 100000000){
			persons[random.nextInt(10)]++;
			
			if(System.currentTimeMillis() - time < 45000){
				Thread.sleep(1000);
			}
			
			if(i % 100000 == 0){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i++;
		}
		
		
		
		
	}

}