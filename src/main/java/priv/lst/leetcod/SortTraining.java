package priv.lst.leetcod;

import java.util.Arrays;
import java.util.Random;

public class SortTraining {
	public static void main(String[] args) {
		int [] array = new int []{8,4,3,1,3,2,9};
		int [] array2 = new int[] {9,8,7,6,5,4,3,2,1};
		for(int i = 0; i < 10; i++){
			shuffle(array2);
			//bubbleSort(array2);
			//insertSort(array);
			fastSort(array, 0, array.length - 1);
			//heapSort(array2);
			//shellSort(array2);
			//bubbleSort_fast(array2);
			System.out.println(Arrays.toString(array2));
		}
	}
	
	public static void heapSort(int [] array){
		int len = array.length;
		
		for(int i = len/2 - 1; i >= 0; i--){
			heap(array, i, len);
		}
		swap(array, 0, --len);
		while(len > 1){
			
			heap(array, 0, len);
			
			swap(array, 0, --len);
		}
	}
	
	public static void heap(int [] array, int start, int len){
		int j = start * 2 + 1;
		if(j >= len) return;
		
		int child = array[j];
		int parent = array[start];
		
		if(j + 1 < len && child < array[j+1]){
			child = array[j+1];
			j++;
		}
		
		if(array[start] < child){
			swap(array, start, j);
		}
		System.out.println(Arrays.toString(array));
		heap(array, j, len);
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
	
	public static void bubbleSort_fast(int [] array){
		int flag = array.length - 1;
		while(flag > 0){
			int temp = 0;//中间变量记录最后一次交换的位置
			for(int i = 0; i < flag; i++){
				if(array[i] > array[i+1]){
					swap(array, i, i+1);
					temp = i;
				}
			}
			flag = temp;
		}
	}
	
	public static void insertSort_old(int [] array){
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
	
	private static void shuffle(int a[]) {//打乱顺序，可以最大概率保证快排不会遇到最坏情况

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
	public static void fastSort(int [] array, int low, int high){
		int i = low - 1;
		int j = high;
		
		while(i < j){
			while(i < j && array[++i] < array[high]);
			while(i < j && array[--j] > array[high]);//这里不可以加等号防止O（n^2）发生
			
			if(i < j){
				swap(array, i, j);
				System.out.println("xxxx" + i +" "+ j);
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
	
	public static void insertSort(int [] array){
		int h = 1;
		int n = array.length;
		for(int i = h; i < n; i=i+h){
			int value = array[i];
			int j = i - 1;
			for(; j >= 0 && value < array[j]; j = j - h){
				array[j + h] = array[j];
			}
			array[j+h] = value;
		}
	}
	
	public static void shellSort(int [] array){
		int h = 0;
		int n = array.length;
	    while (h <= n)                          // 生成初始增量
	    {
	        h = 3 * h + 1;
	    }
		while(h >= 1){
			for(int i = h; i < n; i=i+h){
				int value = array[i];
				int j = i - h;
				for(; j >= 0 && value < array[j]; j = j - h){
					array[j + h] = array[j];
				}
				array[j+h] = value;
			}
			h = (h-1)/3;
		}
	}
}
