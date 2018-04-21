package priv.lst.thinkinjava;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

class ComparaObject implements Comparable<ComparaObject>{
	
	private int first;
	private int second;
	
	public ComparaObject(int first, int second) {
		// TODO Auto-generated constructor stub
		this.first = first;
		this.second = second;
	}
	
	@Override
	public int compareTo(ComparaObject o) {
		// TODO Auto-generated method stub
		if(this.first < o.first){
			return -1;
		}else if (this.first > o.first) {
			return 1;
		}else if(this.second < o.second){
			return -1;
		}else if(this.second > o.second){
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return first + " " + second;
	}
	
}


public class ComparableTraining {
	public static void main(String[] args) {
		/*
		TreeMap<ComparaObject> map = TreeMap<>();
		map.put(new ComparaObject(3, 4), "first);
		*/
		TreeSet<ComparaObject> set = new TreeSet<>();
		set.add(new ComparaObject(3, 4));
		set.add(new ComparaObject(3, 5));
		set.add(new ComparaObject(3, 2));
		set.add(new ComparaObject(2, 4));
		set.add(new ComparaObject(1, 4));
		set.add(new ComparaObject(5, 4));
		set.add(new ComparaObject(4, 4));
		
		for (ComparaObject co : set){
			System.out.println(co.toString());
		}
	}
}