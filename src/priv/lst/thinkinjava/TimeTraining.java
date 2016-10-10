package priv.lst.thinkinjava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTraining {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String str  = simpleDateFormat.format(date);
		String str1 = str.replace(" ", "");
		String str2 = str1.replace("-", "");
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);
	}
}
