package priv.lst.demo;

import java.util.*;
class ListNod {
	int val;
	ListNod next;

	public ListNod(int x) {
		val = x;
	}
}
public class Ad {
	
	public ListNod reverseList(ListNod head, int k) {
		if(head == null || k <= 1) return head;
		
		ListNod pre = new ListNod(-1);
		pre.next = head;
		ListNod cur = pre, temp = null;
		while (cur != null) {
			for (int i = 0; i < k; i++) {
				cur = cur.next;
				if (cur == null)
					return head;
			}
			if(temp == null) head = cur;
			temp = cur.next;
			cur.next = null;
			ListNod node = pre.next;
			reverse(pre);
			node.next = temp;
			pre = node;
			cur = pre;
		}
		return head;
	}

	public ListNod reverse(ListNod head) {
		ListNod cur = head.next;
		ListNod h = head.next;
		while (cur != null) {
			ListNod temp = cur.next;
			cur.next = head.next;
			head.next = cur;
			cur = temp;
		}
		h.next = null;
		return head;
	}
}