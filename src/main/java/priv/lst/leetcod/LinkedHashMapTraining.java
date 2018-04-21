package priv.lst.leetcod;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTraining {
	HashMap<Integer, Integer> map;
	private static final int size = 9;
	
	public static void main(String[] args) {
		new LinkedHashMapTraining().LRU(size);
	}
	
	public void LRU(final int size){
		map = new LinkedHashMap<Integer, Integer>(3, 0.75f, true){
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > size;
			}
		};
		for(int i = 0; i < 10; i++){
			map.put(i, i+10);
		}
		System.out.println(map);
		
		map.get(3);
		
		System.out.println(map);
//		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//			System.out.println();
//		}
	}
}
