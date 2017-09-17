package priv.lst.demo;


import java.util.Scanner;

public class WangYi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
	}
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int [] array = new int[16];
		array[0] = 26;
		int num = 26;
		for(int i = 1; i < 16; i++){
			num--;
			array[i] = array[i] * num;
		}
		for(int i = 1; i < 16; i++){
			array[i] += array[i-1];
		}
		
		
		while(n > 0){
			String s = sc.nextLine();
			int len = s.length();
			
			int res = 0;
			int start = 0;
			for(int i = 0; i < s.length(); i++){
				char ch = s.charAt(i);
				int index = ch - 'a';
				res += getNum(start , index, len - i);
				start = start < index ? index : start;
			}
			if(len > 1){
				res += array[len - 1];
				System.out.println(res);
			}else{
				System.out.println(s.charAt(0) - 'a' + 1);
			}
			n--;
		}
		
	}
	public static int getNum(int start, int end, int len){
		if(len == 1) return end - start;
		int sum = 0;
		start++;
		for(;start < end;start++){
			int temp = start;
			for(int i = 0; i < len; i++){
			}
		}
		
		return sum;
	}*/

	/*private static String s;
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

		System.out.println(max);
	}

	public static int compute(char[] str1, char[] str2) {
		int substringLength1 = str1.length;
		int substringLength2 = str2.length;

		int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

		for (int i = substringLength1 - 1; i >= 0; i--) {
			for (int j = substringLength2 - 1; j >= 0; j--) {
				if (str1[i] == str2[j])
					opt[i][j] = opt[i + 1][j + 1] + 1;// 状态转移方程
				else
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);// 状态转移方程
			}
		}

		int i = 0, j = 0;
		while (i < substringLength1 && j < substringLength2) {
			if (str1[i] == str2[j]) {
				i++;
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1])
				i++;
			else
				j++;
		}
		return opt[0][0];
	}

	public static void printParenthesis(int pos, int n, int open, int close, char[] buffer, ArrayList<String> list) {
		if (close == n) {
			if(!s.equals(new String(buffer)))
				list.add(new String(buffer));
			return;
		}
		if (open > close) {
			buffer[pos] = ')';
			printParenthesis(pos + 1, n, open, close + 1, buffer, list);

		}

		if (open < n) {
			buffer[pos] = '(';
			printParenthesis(pos + 1, n, open + 1, close, buffer, list);
		}

	}*/

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
