package priv.lst.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTraining {
	HashMap<Integer, Integer> map;
	
	public static void main(String[] args) {
		new LinkedHashMapTraining().LRU();
	}
	
	public void LRU(){
		map = new LinkedHashMap<Integer, Integer>(3, 0.75f, true){
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > 5;
			}
		};
		
		for(int i = 0; i < 10; i++){
			map.put(i, i+10);
		}
		
		map.get(3);
		
		System.out.println(map);
//		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//			System.out.println();
//		}
	}
}
