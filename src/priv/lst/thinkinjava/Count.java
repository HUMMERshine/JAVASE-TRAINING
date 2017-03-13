package priv.lst.thinkinjava;

public class Count {
	static{
		System.out.println("init");
	}
	public static void main(String[] args) {
		int a = 0x7fffffff;
		int b = 0x80000000;
		System.out.println(a + " " + b);
		
		long a1 = 0x7FFFFFFFFFFFFFFFL;
        long b1 = 0x8000000000000000L;
        System.out.println(a1 + " "+ b1);
        
        byte a2 = 0x7f;
       // byte b2 = 0x8f;
	}
	private int num;
	public void count(){
		for(int i = 1; i <= 10; i++){
			num += i;
		}
		System.out.println(Thread.currentThread().getName() + "-" + num);
		System.out.println("HelloWorld");
	}
}
