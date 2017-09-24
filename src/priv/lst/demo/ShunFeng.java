package priv.lst.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;


public class ShunFeng{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		long [] array = new long[s.length()];
		array[0] = 1;
		long count = 0;
		for(int i = 1; i < s.length(); i++){
			long temp = (int) Math.pow(2, i);
			array[i] = temp;
			count += temp;
		}
		
		long res =0;
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if (ch > '7'){
				res += 2 * array[s.length() - i - 1];
				break;
			}else if(ch == '7'){
				if(i == s.length()-1){
					res += 2;
					break;
				}
				res += array[s.length() - i - 1];
			}else if(ch > '4'){
				res += array[s.length() - i - 1];
				break;
			}else if(ch == '4'){
				if(i == s.length()-1){
					res += 1;
					break;
				}
				res += 0;
			}else{
				break;
			}
		}
		
		System.out.println((res + count)%((int)Math.pow(10, 9) + 7));
	}
	
	

/*public class XiaoMi {
	private static int count = 0;
	private static ReentrantLock lock = new ReentrantLock();

	private static String s = "u51";


	static class CountIt implements Runnable {
		private LinkedBlockingQueue<String> queue;

		public CountIt(LinkedBlockingQueue<String> queue) {
			// TODO Auto-generated constructor stub
			this.queue = queue;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (!queue.isEmpty()) {
					String str = queue.take();
					if (str.indexOf(s) != -1) {
						try {
							lock.lock();
							count++;
						} finally {
							lock.unlock();
						}

					}
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		while (i++ < 5) {
			try {
				queue.put(sc.nextLine());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		CountIt cou = new CountIt(queue);
		Thread th1 = new Thread(cou);
		Thread th2 = new Thread(cou);
		Thread th3 = new Thread(cou);

		th1.start();
		th2.start();
		th3.start();

		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(count);

	}*/

	/*
	 * char [] chars = s.toCharArray(); int [] array_1 = new int[26]; int []
	 * array_2 = new int[26]; StringBuilder sb = new StringBuilder();
	 * 
	 * for(int i = 0; i < chars.length; i++){ if(chars[i] >='a' && chars[i]
	 * <='z'){ array_1[chars[i] - 'a']++; }else if(chars[i] >='A' && chars[i]
	 * <='Z'){ array_2[chars[i] - 'A']++; }else{ sb.append(chars[i]); } } String
	 * s1 = sb.toString(); sb = new StringBuilder();
	 * 
	 * for(int i = 0; i < 26; i++){ while(array_1[i]-- > 0){
	 * sb.append((char)('a' + i)); } while(array_2[i]-- > 0){
	 * sb.append((char)('A' + i)); } } sb.append(s1);
	 * System.out.println(sb.toString()); }
	 */
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
