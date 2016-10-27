package priv.lst.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class HashMapTraining {
	@Test
	public void training242() {
		String a = "12345";
		Map<Character, Object> map = new HashMap<Character, Object>();
		/*Map<char, int> map2 = new HashMap<char, int>();不能用简单类型*/
		int [] array = new int[2];
		Object x = (Integer) map.get('a');
		System.out.println((Integer)x);
		
		Set<Entry<Character, Object>> entry = map.entrySet();
		for(Map.Entry<Character, Object> ent : entry)
		{
			
		}

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		int n = 10;
		list.toArray(new Integer[list.size()]);//list.toArray(new int[3]);不可以用int（泛型）
		//return list.toArray(new Integer[list.size()]);
		char ch = (char) ('A' + n);
		a = a + ('A' + 1);
		System.out.println(a);
		Map<Character, Integer> map2 = new HashMap<>();
	}
	
	@Test
	public void training166(){
		int a = 1000, b =3;
		int r = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
 		StringBuilder sb = new StringBuilder();
 		if(a % b == 0){
 			sb.append(a/b);
 		}else{
 			sb.append(a/b).append('.');
 		}
 		a = a % b;
		while(a != 0){
			if(map.containsKey(a)){
				sb.insert(map.get(a), "(");
				sb.append(')');
				break;
			}
			map.put(a, sb.length());
			a = a * 10;
			sb.append(a / b);
			a = a % b;
		}
		System.out.println(sb.toString());
	}
}
