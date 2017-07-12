package priv.lst.thinkinjava;

import org.junit.Test;

public class Count {
	static {
		System.out.println("init");
	}

	public static void main(String[] args) {
		int a = 0x7fffffff;
		int b = 0x80000000;
		System.out.println(a + " " + b);

		long a1 = 0x7FFFFFFFFFFFFFFFL;
		long b1 = 0x8000000000000000L;
		System.out.println(a1 + " " + b1);

		byte a2 = 0x7f;
		// byte b2 = 0x8f;
	}

	private int num;

	public void count() {
		for (int i = 1; i <= 10; i++) {
			num += i;
		}
		System.out.println(Thread.currentThread().getName() + "-" + num);
		System.out.println("HelloWorld");
	}

	public void add(Byte b) {
		System.out.println(b + "-");
		b = b++; //这行没效果，先进行 b = b + 1; 再把temp 值赋给 b。
		System.out.println(b + "+");
	}
	
	public void add2(Byte b){
		b++;
	}
	
	@Test
	public void test() {
		Byte a = 127;
		Byte b = 127;
		add(a++);
		System.out.println(a + " ");
		add(++a);
		System.out.println(a + " ");
		add(b);
		System.out.println(b + " ");
		add2(b);//值传递，再装箱操作。
		System.out.println(b + " ");
	}
}
