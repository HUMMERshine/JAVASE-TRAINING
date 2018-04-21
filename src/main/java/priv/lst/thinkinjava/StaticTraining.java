package priv.lst.thinkinjava;

public class StaticTraining {
	static {
		int x = 5;//该x是局部变量，静态块是用来给静态变量赋值用的。
	}
	static int x , y;
	public static void main(String[] args) {
		float f = (float)1.2; // 默认小数是double的
		float f2 = 1.2f;
		f2 = (float)(f2 + 0.3);
		f2 = f2 + 1.3f;
		Short s = 99;
		int a = "asdf".length();
		char ch = 13;
		int i = 033;
		int j = 0x33;
		int k = 101;
		int m = (int)033L;
		short ss = 1;
		ss = (short)(ss + 1);
		System.out.println("value is " + (false ? 10.9 : 9));//输出value is 9.0，因为10.9是double
		System.out.println("value is " + (false ? 10.9 : k));//输出value is 9.0，因为10.9是double
		System.out.println(i + " " + j + " " + k + " " + m);
		int num = 32;
		System.out.println(ss >> 32);//移位运算先进行模32操作。
		//String s = "a";
		//System.out.println(s + 'x');
		System.out.println(x);
		x--;
		myMethod();
		System.out.println(x + " " + y);
		System.out.println( x + y++ + x);
	}
	
	public static void myMethod(){
		System.out.println(x);
		y = x++ + ++x;
	}
}
