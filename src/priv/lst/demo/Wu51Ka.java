package priv.lst.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Wu51Ka {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(sc.nextLine());
		
		int [][] array = new int[k][n];
		int [][] min_max = new int [k][2];
		int row = 0;
		while(row < k){
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++){
				array[row][i] = sc.nextInt();
				min = Math.min(min, array[row][i]);
				max = Math.max(max,  array[row][i]);
			}
			min_max[row][0] = min;
			min_max[row][1] = max;
			row++;
		}
		
		/*int [][] min_max2 = new int [k][2];
		for(int i = 0; i < k; i++){
			int min = min_max[i][0];
			int max = min_max[i][1]; 
			for(int j = 0; j < k; j++){
				if(i != j){
					int min_temp = Math.max(min, array[j][0]);
					int max_temp = Math.min(max, array[j][1]);
					if(min_temp <= max_temp){
						min = min_temp;
						max = max_temp;
					}
				}
			}
			min_max2[i][0] = min;
			min_max2[i][1] = max;
		}*/
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int temp1 = 0;
		int temp2 = 0;
		for(int i = 0; i < k; i++){
			temp1 = min;
			Math.min(min_max[i][0], min);
			temp2 = max;
			Math.max(min_max[i][0], max);
		}
		
		int res1 = -1, res2 = -1;
		for(int i = 0; i < k; i++){
			if(min == min_max[i][0]){
				Arrays.sort(array[i]);
				for(int m  = 0; m < n; m++){
					if(array[i][m] >= temp1){
						res1 = array[i][m];
						break;
					}
				}
				if(res1 == -1) res1 = array[i][n-1];
			}
			if(max == min_max[i][1]){
				Arrays.sort(array[i]);
				for(int m  = 0; m < n; m++){
					if(array[i][m] <= temp2){
						res2 = array[i][m];
						break;
					}
				}
				if(res2 == -1) res2 = array[i][0];
			}
		}
		
		System.out.println();
	}

	/*
	 * public static void main(String[] args) { Scanner sc = new
	 * Scanner(System.in); int n = sc.nextInt(); int [] x = new int[n]; int [] y
	 * = new int[n]; int i = 0; while(i < n){ x[i] = sc.nextInt(); i++; } i = 0;
	 * while(i < n){ y[i] = sc.nextInt(); i++; } Long [][] array = new Long
	 * [n][n];
	 * 
	 * for (int j = 0; j < n; j++){ for(int k = 0; k < n; k++){ array[j][k] =
	 * (long) (Math.abs(x[j]-x[k]) + Math.abs(y[j] - y[k])); } }
	 * 
	 * for(int p = 0; p < n; p++){ Arrays.sort(array[p]); for(int q=1; q < n;
	 * q++){ array[p][q] = array[p][q] + array[p][q-1]; } } int m = 0; while(m <
	 * n){ Long min = array[0][m]; for(int p = 0; p < n; p++){ if(array[p][m] <
	 * min){ min = array[p][m]; } } System.out.print(min); if(m < n-1)
	 * System.out.print(" "); else{ System.out.println(); } m++; } sc.close(); }
	 */
	/*
	 * public static void main(String[] args) { Scanner sc = new
	 * Scanner(System.in); int x = sc.nextInt(); int f = sc.nextInt(); int d =
	 * sc.nextInt(); int p = sc.nextInt();
	 * 
	 * if (d / x <= f ){ System.out.println(d/x); }
	 * 
	 * int sum = d - f * x; int day = f; int cost = x + p;
	 * 
	 * System.out.println(sum / cost + day);
	 * 
	 * //(day - f) * p + day * x < d }
	 */
}
