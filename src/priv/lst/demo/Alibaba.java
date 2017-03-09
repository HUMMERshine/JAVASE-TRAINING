package priv.lst.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Alibaba {
	private static int [] m;
	public static void main(String[] args) {
		Integer [] array = {2,5,1,1,1,2,3,1,1};
		System.out.println(String.valueOf(new char[]{'a','b'}));
		find4part(array);
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
		Iterator<Integer> it = list.iterator();
		System.out.println(list);
		while(it.hasNext()){
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(list);
		
		long x = 1l;
		float y = 1.2f;
		
		System.out.println(x+y);
		
	}
	
	public static void find4part(Integer [] array){
		System.out.println("xxx");
		if(array.length < 7) return;
		Map<Integer, Integer> map = new HashMap<>();
		int [] sum = new int [array.length];
		sum[0] = array[0];
		map.put(sum[0], 0);
		for(int i = 1; i < array.length; i++){
			sum[i] = sum[i-1] + array[i];
			map.put(sum[i], i);
		}
		
		for(int i = 0; i < array.length - 6; i++){
			int temp = sum[i];
			int pos = i;
			int count = 1;
			
			while(count <= 4){
				temp = temp + sum[i] + array[pos + 1];
				if(map.containsKey(temp)){
					pos = map.get(temp);
				}else{
					break;
				}
				if(++count == 4 && pos == array.length - 1){
					System.out.println("true");
					return ;
				}
			}
		}
		System.out.println("false");
		return;
	}
}
