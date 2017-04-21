package priv.lst.demo;

import java.util.*;



public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
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
