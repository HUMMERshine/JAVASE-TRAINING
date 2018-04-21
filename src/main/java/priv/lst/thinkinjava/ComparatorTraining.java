package priv.lst.thinkinjava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Com implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2-o1;
	}
	
}

public class ComparatorTraining {
	public static void main(String[] args) {
		Integer [] array = new Integer [10];
		Random random = new Random();
		for(int i = 0; i < array.length; i++){
			array[i] = random.nextInt(100);
		}
		
		System.out.println(Arrays.toString(array));
		
		Arrays.sort(array, new Com());
	}
}
