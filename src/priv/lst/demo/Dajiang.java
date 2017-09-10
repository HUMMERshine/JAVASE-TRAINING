package priv.lst.demo;

import java.util.*;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Dajiang {

	public static void main(String args[]) {
		int slot = 3 *  60 * 60;
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		HashMap<String, List<Integer>> map = new HashMap<>();
		int i = 0;
		int n = Integer.valueOf(line);
		while (i < n) {
			String str = scanner.nextLine();
			String[] strings = str.split(" ");
			if(map.get(strings[0]) == null){
				map.put(strings[0], new ArrayList<Integer>());
			}
			List<Integer> list = map.get(strings[0]);
			list.add(getInt(strings[1]));
			i++;
		}
		
		for(Map.Entry<String, List<Integer>> entry: map.entrySet()){
			String day = entry.getKey();
			String next = nextDay(day);
			List<Integer> list = entry.getValue();
			
			int start = -1;
			int end = -1;
			for(Integer time : list){
				if(time >= slot ){
					if(start == -1){
						start = time;
					}else{
						start = time < start ? time : start;
					}
					if(end == -1){
						end = time;
					}else{
						end = time > end ? time : end;
					}
				}
			}

			int all = -1;
			if(next != null){
				List<Integer> temp = map.get(next);
				if(temp != null)
				for(Integer time : temp){
					if(time < slot ){
						if(all == -1){
							all = time;
						}else{
							all = time > all ? time : all;
						}
					}
				}
			}
			
			int all_time = 0;
			if(all == -1){
				if(start != -1 && end != -1){
					all_time = end - start;
				}
			}else{
				if(start != -1){
					all_time = all + 24 * 60 * 60 - start;
				}
			}
			
			if(all_time != 0){
				System.out.println(day + " " + all_time);
			}
		}
		
	}
	public static int getInt(String s){
		String [] strs = s.split(":");
		int a = Integer.valueOf(strs[0]);
		int b = Integer.valueOf(strs[1]);
		int c = Integer.valueOf(strs[2]);
		return c + b * 60 + a * 60 * 60;
	}
	public static String nextDay(String s){
		String [] strings = s.split("\\.");
		int day = Integer.valueOf(strings[1]);
		day++;
		if(day > 31){
			return null;
		}
		if(day < 10){
			return strings[0]+"."+day;
		}
		return strings[0]+".0"+day;
	}

}