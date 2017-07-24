package priv.lst.thinkinjava;

import java.io.UnsupportedEncodingException;

public class StringTraining {
	public static void main(String[] args) throws UnsupportedEncodingException{
		String str1 = "ab";
		String str2 = "cd";
		String str = "ab" + "cd";
		String str3 = str1 + str2;
		String str4 = "abcd";
		final String str5 = "cd";
		String str61 = "ab" + str5;
		
		System.out.println(str == str4);
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
		System.out.println(str4 == str61);
		
		String s3 = "Hello world 中国";
		System.out.println(new String(s3.getBytes("utf-8"), "utf-8"));
		System.out.println(new String(s3.getBytes("GBK"), "gbk"));
		String s1 = "ab" + "cd";
		String s2 = "abcd";
		System.out.println(s1 == s2);
		String str6 = "b";
		String str7 = "a" + str6;
		String str67 = "ab";
		System.out.println("str7 = str67 : " + (str7 == str67));
		final String str8 = "b";
		String str9 = "a" + str8;
		String str89 = "ab";
		System.out.println("str9 = str89 : " + (str9 == str89));
	}
}
