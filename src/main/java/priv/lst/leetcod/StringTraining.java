package priv.lst.leetcod;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class StringTraining {
	public static void main(String[] args) throws UnsupportedEncodingException {
		new StringTraining().compareVersion("1", "0");
	}

	public int compareVersion(String version1, String version2) {
		String[] strs1 = version1.split("\\.");
		String[] strs2 = version2.split("\\.");
		int i = 0;
		System.out.println(strs1.length);
		System.out.println(strs2.length);
		for (; i < strs1.length && i < strs2.length; i++) {
			String str1 = strs1[i];
			String str2 = strs2[i];

			if (Integer.valueOf(str1) > Integer.valueOf(str2)) {
				return 1;
			}
			if (Integer.valueOf(str1) < Integer.valueOf(str2)) {
				return -1;
			}
		}

		if (i < strs1.length) {
			return 1;
		}

		if (i < strs2.length) {
			return -1;
		}

		return 0;
	}

	@Test
	public void subString() {
		String s = "12345";
		System.out.println(s.substring(0, 0));
	}

	public int Kmp_strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		char[] chars = needle.toCharArray();
		int[] next = getNext(chars);
		int i = 0, j = 0;
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
					j = next[j] + 1;
				}
			}
		}

		return (j == needle.length()) ? (i - needle.length()) : -1;
	}

	public int[] getNext(char[] chars) {
		int[] next = new int[chars.length];

		next[0] = -1;
		for (int i = 1, j = 0; i < chars.length; i++) {
			j = next[i - 1];
			while (chars[j + 1] != chars[i] && (j >= 0)) {
				j = next[j];
			}
			if (chars[i] == chars[j + 1]) {
				next[i] = j + 1;
			} else {
				next[i] = -1;
			}
		}

		return next;
	}

	@Test
	public void StringSplit() {
		String s = "aaa  bb c ";
		String[] strs = s.split(" ");
		String[] strs2 = s.split("\\s+");// 通过使用正则表达式可以去除只能分隔单个空格的情况。
		System.out.println(strs.length + " " + strs2.length);

		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			if (str.length() > 0 && str.charAt(0) != ' ') {
				sb.insert(0, str).insert(0, ' ');
				System.out.println(sb.toString());
			}
		}
		if (sb.length() == 0)
			return;
		System.out.println(sb.deleteCharAt(0).toString());

		String str = "1.2.3.4.5..6.7";
		String[] array = str.split("\\.");
		System.out.println(Arrays.asList(array));
		String str2 = "1^2^3^4^5^^6^7";
		String[] array2 = str2.split("\\^");
		System.out.println(Arrays.asList(array2));
	}

	@Test
	public void stringPlus() {
		String a = "12345", b = "92345";
		StringBuilder sb = new StringBuilder();
		int signal = 0;
		for (int i = a.length() - 1, j = b.length() - 1; j >= 0 || i >= 0; i--, j--) {
			int x, y;
			if (i < 0) {
				x = 0;
			} else {
				x = a.charAt(i) - '0';
			}
			if (j < 0) {
				y = 0;
			} else {
				y = b.charAt(j) - '0';
			}
			int sum = x + y + signal;
			if (sum >= 10) {
				signal = 1;
				sb.insert(0, sum - 10);
			} else {
				signal = 0;
				sb.insert(0, sum);
			}
		}
		if (signal == 1)
			sb.insert(0, 1);
		System.out.println(sb.toString());
	}

	@Test
	public void stringMul() {
		String num1 = "92345";
		int n = 2;
		StringBuilder sb = new StringBuilder();
		int signal = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int x = num1.charAt(i) - '0';
			int sum = x * n + signal;

			signal = sum / 10;
			sb.insert(0, sum % 10);

		}
		if (signal != 0)
			sb.insert(0, signal);
		System.out.println(sb.toString());
	}

	@Test
	public void calculate() {
		String s = " 1 +24-9+4+9* 2 / 3";
		HashSet<Character> set = new HashSet<>();
		set.add('+');
		set.add('-');
		set.add('*');
		set.add('/');
		int result = 0, temp = 0, num = -1, i = 0;
		char signal = '+';
		while (i < s.length()) {
			if (s.charAt(i) == ' ') {
				i++;
				continue;
			}
			if (set.contains(s.charAt(i))) {
				if (s.charAt(i) == '+' || s.charAt(i) == '-') {
					if (signal == '+') {
						System.out.println(result + " " + temp);
						result = result + temp;
					} else {
						result = result - temp;
					}
					signal = s.charAt(i);
				} else {
					char ch = s.charAt(i++);
					int num2 = 0;
					while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-') {
						if (s.charAt(i) == ' ') {
							i++;
							continue;
						}
						if (set.contains(s.charAt(i))) {
							if (ch == '*') {
								System.out.println(temp + "*");
								temp = temp * num2;
							} else {
								temp = temp / num2;
							}
							ch = s.charAt(i);
							num2 = 0;
						} else {
							num2 = num2 * 10 + (s.charAt(i) - '0');
						}
						i++;
					}
					if (num2 != 0) {
						if (ch == '*') {
							temp = temp * num2;
						} else {
							temp = temp / num2;
						}
					}
					continue;
				}
				temp = 0;
			} else {
				temp = temp * 10 + (s.charAt(i) - '0');
			}
			i++;
		}
		if (temp != 0) {
			if (signal == '+') {
				result = result + temp;
			} else {
				result = result - temp;
			}
		}
		System.out.println(result);
	}

	@Test
	public void StringBuilderDemo() {
		StringBuilder sb = new StringBuilder();
		sb.append(new Integer(1));
		sb.append(1);
		Integer i = 1;
		sb.append((char) 2);
		System.out.println(sb.toString());
	}
}
