package priv.lst.leetcode;

import java.util.Random;

public class SortTraining {
	public static void main(String[] args) {
		int [] array = new int []{3,6,7,4,3,3};
		fastSort(array, 0, array.length - 1);
		for(int i : array){
			System.out.println(i);
		}
	}
	private void shuffle(int a[]) {//打乱顺序，可以最大概率保证快排不会遇到最坏情况

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
	public static void fastSort(int [] array, int low, int high){
		
		int i = low - 1;
		int j = high;
		
		while(true){
			while(i < j && array[++i] < array[high]){}
			while(i < j && array[--j] > array[high]){}
			
			if(i < j){
				swap(array, i, j);
			}else{
				break;
			}
			
		}
		swap(array, i, high);
		if(i > low)
			fastSort(array, low, i - 1);
		if(i < high)
			fastSort(array, i + 1, high);
	}
	
	public static void swap(int [] array, int x, int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
