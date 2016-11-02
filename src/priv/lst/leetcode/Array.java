package priv.lst.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Array {
	@Test
	public void test88() {
		int nums[] = {};
		int[] nums2 = new int[10];
		List<Integer> list = new ArrayList<Integer>(10);

		System.out.println(list.size());
		System.out.println(nums.length);
		System.out.println(nums2[0] + " " + nums2[1]);
	}

	@Test
	public void testRotate() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7};
		int k = 16;
		int step = k % nums.length;
		int [] array = new int[step];
		int temp;
		for (int i = 0; i < step; i++) {
			int current = nums[i];
			int j = i;
			for (;j + step < nums.length; j = j + step) {

				temp = nums[j + step];
				nums[j + step] = current;
				current = temp;
			}
			array[(j+step)%nums.length] = current;
		}
		for(int m = 0; m < step; m++)
		{
			nums[m] = array[m];
		}
		for(int n : nums)
		{
			System.out.print(n + " ");
		}
	}
	
	@Test
	public void subList()
	{
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(2);
		System.out.println(list.subList(0, 1));
	}
	
	//64
	@Test
	public void minPathSum(){
		int [][] nums = new int [3][5];
		System.out.println(nums.length + " " + nums[0].length);
	}
	
}
