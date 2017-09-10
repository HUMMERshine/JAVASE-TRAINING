package priv.lst.thinkinjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTraining {
	public static void main(String[] args) {
		Integer [] arrays;
		arrays = new Integer[]{new Integer(1), new Integer(2)};
		Integer [] arrays2 = null;
		/*
		 * arrays2 = {new Integer(1), new Integer(2)};
		 * 该句报错，因为{}这种形式只能在定义数组时使用。
		 * 如下array3
		 */
		Integer [] arrays3 = {new Integer(1), new Integer(2)};
		Integer [] arrays4 = null;
		System.out.println(arrays);
		System.out.println(arrays2);
		System.out.println(arrays3);
		System.out.println(arrays4);
		
		method1(1, 2, 3, 4);
		method1((Object [])new Integer[]{1, 2, 3, 4, 5});
		
		List [] lists = new ArrayList[10];
		//List<String> [] lists2 = new ArrayList<String>[10];
	}
	
	public static <T> void method1(Object ... args){
		System.out.println(Arrays.toString(args));
		
		T [] array;
	}
}
