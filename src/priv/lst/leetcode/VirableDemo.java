package priv.lst.leetcode;

import java.util.*;

import org.junit.Test;

public class VirableDemo {
	
	public static void main(String[] args) {
		new VirableDemo().test();
	}
	
	public List<Integer> voke()
	{
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(new Integer(3));
		
		return list;
	}
	
	@Test
	public void test()
	{
		System.out.println(voke());
	}
}
