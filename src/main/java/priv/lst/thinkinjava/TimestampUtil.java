package priv.lst.thinkinjava;

import java.sql.Timestamp;
import java.util.Date;

public class TimestampUtil {
	public static void main(String[] args) {
		Timestamp time = new Timestamp(new Date().getTime());
		System.out.println(time.toString());
	}
}
