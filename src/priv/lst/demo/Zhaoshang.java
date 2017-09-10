package priv.lst.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Zhaoshang implements Runnable{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		int len = s.length();
		len = len / 2;

		ArrayList<String> list = new ArrayList<>();
		char[] cs = new char[8];
		printParenthesis(0, len, 0, 0, cs, list);

		char[] src = s.toCharArray();
		int[] array = new int[len * 2 + 1];
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (!s.equals(list.get(i))) {
				char[] des = list.get(i).toCharArray();
				boolean flag = false;
				for(int m = 0; m < len * 2; m++){
					if(src[m] != des[m]){
						flag = true;
					}
				}
				if(!flag) continue; 
				int value = compute(src, des);
				System.out.println(value);
				array[value]++;
				if (array[value] > max) {
					max = array[value];
				}
			}
		}

		System.out.println(addBlodTag);
	}

	public String addBlodTag(String s, String[] dict) {
		int begin = 0, end = 0;
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for(int i = 0; i < s.length(); i++){
			
			if(i > end && flag){
				sb.append("<b>");
				sb.append(s.substring(begin, end + 1));
				sb.append("</b>");
				flag = false;
				begin = i;
				end = i;
			}
			
			for(int j = 0; j < dict.length; j++){
				if(s.length() - i >= dict[j].length() && s.substring(i, i + dict[j].length()).equals(dict[j])){
					if(i + dict[j].length() - 1 > end){
						end = i + dict[j].length() - 1;
					}
					flag = true;
				}
			}
			if(!flag){
				sb.append(i);
				begin = i + 1;
				end = i + 1;
			}
			
		}
		
		return sb.toString();
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
