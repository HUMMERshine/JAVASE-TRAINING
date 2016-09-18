package priv.lst.thinkinjava;

import java.util.concurrent.TimeUnit;

public class ThreadTraining {
	private static boolean stopRequested;
	public volatile static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		// stop();
		volatileTest();
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
}
