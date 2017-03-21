package priv.lst.thinkinjava;

import java.util.*;

public class HashMapTraining {
	private static HashMap<String, String> map;
	
	public static void main(String[] args) {
		map = new HashMap<>();
		
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		map.put("ddd", "444");
		map.put("eee", "555");
		
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entrys.iterator();
		
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.print(entry.getKey());
			System.out.println(" " + entry.getValue() + " " );
			it.remove();
		}
		System.out.println(entrys);
	}
}
