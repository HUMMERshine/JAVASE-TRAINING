package priv.lst.demo;

import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int a, b;
		int count = cin.nextInt();
		int m = 1;
		while (m <= count) {
			int temp = cin.nextInt();
			int [] array = new int[temp];
			for(int i = 0; i < temp; i++){
				array[i] = cin.nextInt();
			}
			int [] res = compute(array, array.length);
			System.out.printf("Case #%d: %d %d\n", m, res[0], res[1]);
			m++;
		}
	}
	public static int[] compute(int[] nums, int n) {
		int[][] dp = new int[n + 1][n + 1];
		int[] sum = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			dp[i][i] = nums[i - 1];
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		for(int i = n - 1; i > 0; i--) {
			for(int j = i; j <= n; j++) {
				dp[i][j] = sum[j] - sum[i - 1] - Math.min(dp[i + 1][j], dp[i][j - 1]); 
			}
		}
		return new int[]{dp[1][n], sum[n] - dp[1][n]};
	}
}
