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
}
