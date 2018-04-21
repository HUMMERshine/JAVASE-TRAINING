package priv.lst.thinkinjava;

class Test{
	/*
	 * synchronized 作用在静态方法和非静态方法上时，是不相互阻塞的，可以并行运行。
	 * 一个是给class对象加锁，一个是给Test对象加锁。
	 */
	public synchronized static void test1(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test1");
	}
	
	public synchronized void test2(){
		System.out.println("test2");
	}
}

public class SynchronizedTraining{
	public static void main(String[] args) {
		final Test test = new Test();
		new Thread(){
			public void run() {
				test.test1();
			};
		}.start();
		
		new Thread(){
			public void run() {
				test.test2();
			};
		}.start();
	}
	
	
	
	
}
