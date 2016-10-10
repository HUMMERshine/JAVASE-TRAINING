package priv.lst.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HashSetTraining {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set2.add(1);
		set2.add(2);
		System.out.println(set2.addAll(set1));
		System.out.println(set2);
 	}
}
