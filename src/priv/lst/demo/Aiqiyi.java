package priv.lst.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Aiqiyi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int count = 0;
		if(m > n){
			for (int i = 1; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					double x = Math.sqrt(i * j);
					if (x - (int) (x) == 0) {
						count++;
					}

				}
			}
			count = count * 2 + n;
			for (int i = 1; i <= n; i++) {
				for (int j = n + 1; j <= m; j++) {
					double x = Math.sqrt(i * j);
					if (x - (int) (x) == 0) {
						count++;
					}

				}
			}
		}else{
			for (int i = 1; i <= m; i++) {
				for (int j = i + 1; j <= m; j++) {
					double x = Math.sqrt(i * j);
					if (x - (int) (x) == 0) {
						count++;
					}

				}
			}
			count = count * 2 + m;
			for (int i = 1; i <= m; i++) {
				for (int j = m + 1; j <= n; j++) {
					double x = Math.sqrt(i * j);
					if (x - (int) (x) == 0) {
						count++;
					}

				}
			}
		}
		
		System.out.println(count);

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
