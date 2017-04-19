package priv.lst.thinkinjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTraining {
	public static void main(String[] args) {
		String regex = "\\d{5}";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher("1234");
		boolean result = matcher.matches();

		System.out.println(result);

		System.out.println("12345".matches("\\d{5}"));
	}

	@Test
	public void emailTest() {
		String regex = "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$";
		boolean result = "a_lst@163.com".matches(regex);
		System.out.println(result);

	}
	
	@Test
	public void httpTest() {
		String regex = "^((http|https)://)$";
		boolean result = "a_lst@163.com".matches(regex);
		System.out.println(result);

	}
}
