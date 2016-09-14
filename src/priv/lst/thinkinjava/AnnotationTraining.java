package priv.lst.thinkinjava;

import java.util.Random;

public class AnnotationTraining {
	public static void main(String[] args) {
		Random random = new Random();
		int a = random.nextInt(6) + 1;
		int b = random.nextInt(6) + 1;
		a = 5;
		b = 1;
		System.out.println("你们国庆节将要旅行的城市为： "+ " " + Math.abs((1991 * a) + 23 * 7 + (1988 * b) + 24 * 7) % 10 +"号城市");
	}
}
