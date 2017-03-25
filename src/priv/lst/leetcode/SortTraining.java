package priv.lst.leetcode;

import java.util.Random;

public class SortTraining {
	public static void main(String[] args) {
		int [] array = new int []{8,4,3,1,3,2,9};
		//bubbleSort(array);
		//insertSort(array);
		fastSort(array, 0, array.length - 1);
		for(int i : array){
			System.out.println(i);
		}
	}
	
	public static void bubbleSort(int [] array){
		for(int i = 0; i < array.length; i++){
			for(int j = i + 1; j < array.length; j++){
				if(array[i] > array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static void insertSort(int [] array){
		for(int i = 1; i < array.length; i++){
			int num = array[i];
			int j = i - 1;
			for(; j >= 0; j--){
				if(array[j] < array[i]){
					break;
				}
			}
			if(i-1 != j){
				for(int k = i - 1; k > j; k--){
					array[k+1] = array[k];
				}
				array[j+1] = num;
			}
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
			while(i < j && array[--j] >= array[high]){}//相等的都当做大于。
			
			if(i < j){
				swap(array, i, j);
				System.out.println("xxxx" + i +" "+ j);
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
