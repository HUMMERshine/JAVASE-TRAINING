package priv.lst.thinkinjava;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadTraining {
	private static boolean stopRequested;
	public volatile static int count = 0;

	@Test
	public void testSemaphore(){
		PrintQueue printQueue = new PrintQueue();
		Thread [] thread = new Thread[10];
		for(int i = 0; i<10; i++){
			thread[i] = new Thread(new Job(printQueue), "Thread" + i);
		}
		for(int i = 0; i<10 ; i++){
			thread[i].start();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		// stop();
		//volatileTest();
		Runnable runnable = new Runnable(){
			Count count = new Count();
			@Override
			public void run() {
				// TODO Auto-generated method stub
				count.count();
			}
			
		};
		for(int i = 0; i < 10; i++){
			new Thread(runnable).start();
			//Thread.sleep(10);
		}
	}

	public  static void inc() {
		// 这里延迟1毫秒，使得结果明显
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		
		synchronized (ThreadTraining.class){
			count++;
		}
	}

	// 因为没有锁的支持，volatile的修改不能依赖于当前值，当前值可能在其他线程中被修改。
	public static void volatileTest() throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					ThreadTraining.inc();
				}
			}).start();
		}
		// 这里每次运行的值都有可能不同,可能不为1000
		Thread.sleep(1000);
		System.out.println("运行结果:ThreadTraining.count=" + ThreadTraining.count);
	}

	public static void stop() throws InterruptedException {
		Thread backgroundThread = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (!stopRequested) {
					System.out.print(i++ + " ");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(5);
		stopRequested = true;
	}
	
	/*public class Count {
		private int num;
		public void count(){
			for(int i = 1; i <= 10; i++){
				num += i;
			}
			System.out.println(Thread.currentThread().getName() + "-" + num);
		}
	}*/
	
	@Test
	public void countTest(){
		Runnable runnable = new Runnable(){
			Count count = new Count();
			@Override
			public void run() {
				// TODO Auto-generated method stub
				count.count();
			}
		};
		for(int i = 0; i < 10; i++){
			new Thread(runnable).start();
		}
	}
	
	class PrintQueue{
		private Semaphore semaphore;
		public PrintQueue(){
			this.semaphore = new Semaphore(1);
		}
		public void printJob(Object document){
			try {
				semaphore.acquire();
				long duration = (long ) (Math.random() * 10);
				System.out.printf("%s: PrintQueue: printing a job during %d seconds\n", Thread.currentThread().getName(), duration);
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//System.out.println(semaphore.availablePermits());
				semaphore.release();
				//System.out.println(semaphore.availablePermits());
			}
		}
	}
	class Job implements Runnable{
		private PrintQueue printQueue; 
		public Job(PrintQueue printQueue){
			this.printQueue = printQueue;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
			printQueue.printJob(new Object());
			System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
		}
	}
	
	
	
}
