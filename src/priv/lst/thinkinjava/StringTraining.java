package priv.lst.thinkinjava;

public class StringTraining {
	public static void main(String[] args) {
		String str1 = "ab";
		String str2 = "cd";
		String str = "ab" + "cd";
		String str3 = str1 + str2;
		String str4 = "abcd";
		final String str5 = "cd";
		String str6 = "ab" + str5;
		
		System.out.println(str == str4);
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
		System.out.println(str4 == str6);
	}
}
