package priv.lst.demo;

import java.util.*;

class Num{
	public Num(char ch){
		switch(ch){
		case '1':
			ch1 = new int[3];
			ch1[1] = 1;
			ch2 = new int[3];
			ch2[1] = 1;
			ch3 = new int[3];
			ch3[1] = 1;
			ch4 = new int[3];
			ch4[1] = 1;
			ch5 = new int[3];
			ch5[1] = 1;
			break;
		case '2':
			ch1 = new int[3];
			ch1[1] = ch1[2] = ch1[0] =1;
			ch2 = new int[3];
			ch2[2] = 1;
			ch3 = new int[3];
			ch3[1] = ch3[2] = ch3[0] =1;
			ch4 = new int[3];
			ch4[0] = 1;
			ch5 = new int[3];
			ch5[1] = ch5[2] = ch5[0] =1;
			break;
		case '3':
			ch1 = new int[3];
			ch1[0] = ch1[1] = ch1[2] =1;
			ch2 = new int[3];
			ch2[2] = 1;
			ch3 = new int[3];
			ch3[1] = ch3[2] = ch3[0] =1;
			ch4 = new int[3];
			ch4[2] = 1;
			ch5 = new int[3];
			ch5[1] = ch5[2] = ch5[0] =1;
			break;
		case '4':
			ch1 = new int[3];
			ch1[0] = ch1[2] = 1;
			ch2 = new int[3];
			ch2[2] = ch2[0] = 1;
			ch3 = new int[3];
			ch3[1] = ch3[2] = ch3[0] =1;
			ch4 = new int[3];
			ch4[2] = 1;
			ch5 = new int[3];
			ch5[2] =1;
			break;
		case '5':
			ch1 = new int[3];
			ch1[0] = ch1[1] = ch1[2] =1;
			ch2 = new int[3];
			ch2[0] = 1;
			ch3 = new int[3];
			ch3[1] = ch3[2] = ch3[0] =1;
			ch4 = new int[3];
			ch4[2] = 1;
			ch5 = new int[3];
			ch5[1] = ch5[2] = ch5[0] =1;
			break;
		case '6':
			ch1 = new int[3];
			ch1[0] = ch1[1] = ch1[2] =1;
			ch2 = new int[3];
			ch2[0] = 1;
			ch3 = new int[3];
			ch3[1] = ch3[2] = ch3[0] =1;
			ch4 = new int[3];
			ch4[2] = ch4[0] = 1;
			ch5 = new int[3];
			ch5[1] = ch5[2] = ch5[0] =1;
			break;
		case '7':
			ch1 = new int[3];
			ch1[0] = ch1[2] = ch1[1] = 1;
			ch2 = new int[3];
			ch2[2] = 1;
			ch3 = new int[3];
			ch3[2] = 1;
			ch4 = new int[3];
			ch4[2] = 1;
			ch5 = new int[3];
			ch5[2] = 1;
			break;
		case '8':
			ch1 = new int[3];
			ch1[0] = ch1[1] = ch1[2] =1;
			ch2 = new int[3];
			ch2[0] = ch2[2] = 1;
			ch3 = new int[3];
			ch3[1] = ch3[2] = ch3[0] =1;
			ch4 = new int[3];
			ch4[2] = ch4[0] = 1;
			ch5 = new int[3];
			ch5[1] = ch5[2] = ch5[0] =1;
			break;
		case '9':
			ch1 = new int[3];
			ch1[0] = ch1[1] = ch1[2] =1;
			ch2 = new int[3];
			ch2[0] = ch2[2] = 1;
			ch3 = new int[3];
			ch3[1] = ch3[2] = ch3[0] =1;
			ch4 = new int[3];
			ch4[2] = 1;
			ch5 = new int[3];
			ch5[1] = ch5[2] = ch5[0] =1;
			break;
		case '0':
			ch1 = new int[3];
			ch1[0] = ch1[1] = ch1[2] =1;
			ch2 = new int[3];
			ch2[0] = ch2[2] = 1;
			ch3 = new int[3];
			ch3[2] = ch3[0] =1;
			ch4 = new int[3];
			ch4[2] = ch4[0] = 1;
			ch5 = new int[3];
			ch5[1] = ch5[2] = ch5[0] =1;
			break;
		case '+':
			ch1 = new int[3];
			ch2 = new int[3];
			ch2[1] = 1;
			ch3 = new int[3];
			ch3[2] = ch3[0] = ch3[1] = 1;
			ch4 = new int[3];
			ch4[1] = 1;
			ch5 = new int[3];
			break;
		case '-':
			ch1 = new int[3];
			ch2 = new int[3];
			ch3 = new int[3];
			ch3[2] = ch3[0] = ch3[1] = 1;
			ch4 = new int[3];
			ch5 = new int[3];
			break;
		case '*':
			ch1 = new int[3];
			ch2 = new int[3];
			ch2[0] = ch2[2] = 1;
			ch3 = new int[3];
			ch3[1] = 1;
			ch4 = new int[3];
			ch4[0] = ch4[2] = 1;
			ch5 = new int[3];
			break;
		case '/':
			ch1 = new int[3];
			ch2 = new int[3];
			ch2[2] = 1;
			ch3 = new int[3];
			ch3[1] = 1;
			ch4 = new int[3];
			ch4[0] = 1;
			ch5 = new int[3];
			break;
		case '=':
			ch1 = new int[4];
			ch2 = new int[4];
			ch2[0] =ch2[1] =ch2[2] =ch2[3] = 1;
			ch3 = new int[4];
			ch4 = new int[4];
			ch4[0] =ch4[1] =ch4[2] =ch4[3] = 1;
			ch5 = new int[4];
			break;
		case '.':
			ch1 = new int[2];
			ch2 = new int[2];
			ch3 = new int[2];
			ch4 = new int[2];
			ch4[0]= ch4[1] = 1;
			ch5 = new int[2];
			ch5[0] = ch5[1] = 1;
			break;
		}
	}
	public int [] ch1;
	public int [] ch2;
	public int [] ch3;
	public int [] ch4;
	public int [] ch5;
}

public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		String s = cin.nextLine();
		
		String [] strs  = s.split(" ");
		
		int x = Integer.valueOf(strs[0]);
		char ch = strs[1].charAt(0);
		int y = Integer.valueOf(strs[2]);
		
		int result = 0;
		float result2 = 0;
		switch(ch){
		case '+':
			result = x + y;
			break;
		case '-':
			result = x - y;
			break;
		case '*':
			result = x * y;
			break;
		case '/':
			result = x / y;
			result2 = (float)x / y;
			result2   =  (float)(Math.round(result2*100))/100;
			break;
		}
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		ArrayList<Integer> list4 = new ArrayList<>();
		ArrayList<Integer> list5 = new ArrayList<>();
		doIt1(strs[0], list1, list2, list3, list4, list5);
		doIt2(strs[1].charAt(0), list1, list2, list3, list4, list5);
		doIt1(strs[2], list1, list2, list3, list4, list5);
		doIt2('=', list1, list2, list3, list4, list5);
		if(ch != '/' || x % y == 0)
			doIt1(result+"", list1, list2, list3, list4, list5);
		else{
			doIt3(result2+"", list1, list2, list3, list4, list5);
		}
		
		printIt(list1);
		printIt(list2);
		printIt(list3);
		printIt(list4);
		printIt(list5);
		
	}
	
	public static void printIt(ArrayList<Integer> list){
		for(int j = 0; j < list.size()-2; j++){
			if(list.get(j) == 0){
				System.out.print(" ");
			}else{
				System.out.print("*");
			}
		}
		System.out.println();
	}
	
	public static void doIt1(String str, ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3, ArrayList<Integer> list4, ArrayList<Integer> list5){
		for(int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			Num num = new Num(temp);
			for(int j : num.ch1){
				list1.add(j);
			}
			for(int j : num.ch2){
				list2.add(j);
			}
			for(int j : num.ch3){
				list3.add(j);
			}
			for(int j : num.ch4){
				list4.add(j);
			}
			for(int j : num.ch5){
				list5.add(j);
			}
			list1.add(0);list1.add(0);
			list2.add(0);list2.add(0);
			list3.add(0);list3.add(0);
			list4.add(0);list4.add(0);
			list5.add(0);list5.add(0);
		}
		
	}
	
	public static void doIt3(String str, ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3, ArrayList<Integer> list4, ArrayList<Integer> list5){
		for(int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			Num num = new Num(temp);
			if(temp == '.'){
				list1.add(0);list1.add(0);
				list2.add(0);list2.add(0);
				list3.add(0);list3.add(0);
				list4.add(0);list4.add(0);
				list5.add(0);list5.add(0);
			}
			for(int j : num.ch1){
				list1.add(j);
			}
			for(int j : num.ch2){
				list2.add(j);
			}
			for(int j : num.ch3){
				list3.add(j);
			}
			for(int j : num.ch4){
				list4.add(j);
			}
			for(int j : num.ch5){
				list5.add(j);
			}
			if(temp == '.'){
			list1.add(0);list1.add(0);
			list2.add(0);list2.add(0);
			list3.add(0);list3.add(0);
			list4.add(0);list4.add(0);
			list5.add(0);list5.add(0);
			}
		}
		list1.add(0);list1.add(0);
		list2.add(0);list2.add(0);
		list3.add(0);list3.add(0);
		list4.add(0);list4.add(0);
		list5.add(0);list5.add(0);
	}
	
	public static void doIt2(char str, ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3, ArrayList<Integer> list4, ArrayList<Integer> list5){
			Num num = new Num(str);
			for(int j : num.ch1){
				list1.add(j);
			}
			list1.add(0);list1.add(0);
			for(int j : num.ch2){
				list2.add(j);
			}
			list2.add(0);list2.add(0);
			for(int j : num.ch3){
				list3.add(j);
			}
			list3.add(0);list3.add(0);
			for(int j : num.ch4){
				list4.add(j);
			}
			list4.add(0);list4.add(0);
			for(int j : num.ch5){
				list5.add(j);
			}
			list5.add(0);list5.add(0);
	}

	public static int ladderLength(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || start.length() == 0 || end.length() == 0 || start.length() != end.length())
			return 0;

		Queue<String> queue = new LinkedList<String>();
		int floor = 1; 
		int curnum = 1;
		int nextnum = 0;

		queue.add(start);

		while (!queue.isEmpty()) {
			String word = queue.poll();
			curnum--;

			for (int i = 0; i < word.length(); i++) {
				char[] wordArray = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					wordArray[i] = j;
					String temp = new String(wordArray);

					if (temp.equals(end))
						return floor + 1;
					if (dict.contains(temp)) {
						queue.add(temp);
						nextnum++;
						dict.remove(temp);
					}
				}
			}

			if (curnum == 0) {
				curnum = nextnum;
				nextnum = 0;
				floor++;
			}
		}

		return 0;
	}
	
	public int Max(int array[] ){
		int max = Integer.MIN_VALUE;
		int i = 0, j = array.length;
		while(i < j){
			int temp = (j - i) * (array[j] - array[i]);
			if(temp > max) max = temp;
			while(i < j && array[i] >= array[i + 1]){i++;}
			i++;
			temp = (j - i) * (array[j] - array[i]);
			if(temp > max) max = temp;
			while(i < j && array[j] >= array[j + 1]){j--;}
			j--;
			temp = (j - i) * (array[j] - array[i]);
			if(temp > max) max = temp;
		}
		
		return 0;
		
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x ){ val = x;}
	}
	
	public ListNode reverseList(ListNode head, int k){
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode cur = pre, temp = null;
		while(cur != null){
			for(int i = 0; i < k; i++){
				if(cur == null) return pre.next;
				cur=cur.next;
			}
			temp = cur.next;
			cur.next = null;
			ListNode node = pre.next;
			reverse(pre);
			node.next = temp;
			pre = node;
			cur = pre;
		}
			
		return pre.next;
	}
	public void reverse(ListNode head){
		ListNode cur = head.next;
		while(cur != null){
			ListNode temp = cur.next;
			cur.next = head.next;
			head.next = cur;
			cur = temp;
		}
	}
}
/*
 * Scanner cin = new Scanner(System.in);
 * 
 * int n = cin.nextInt(); int k = cin.nextInt(); int [] array = new int[n];
 * 
 * int j = 0; while(j < n){ array[j++] = cin.nextInt(); }
 * 
 * j = 0; int [] temp = new int[n]; while(j < k){ int i = 0; for(; i < n-1;
 * i++){ temp[i] = (array[i] + array[i+1])%100; } temp[i] = (array[i] +
 * array[0])%100; int [] s = array; array = temp; temp = s; j++; }
 * 
 * j = 0; while(j < n - 1){ System.out.print(array[j++] + " "); }
 * System.out.println(array[j++]); }
 */
