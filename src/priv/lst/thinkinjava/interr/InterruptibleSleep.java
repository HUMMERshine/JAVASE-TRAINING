package priv.lst.thinkinjava.interr;

public class InterruptibleSleep {
	public static void main(String[] args) throws InterruptedException {
		Thread sleeper = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("I woke up by myself.");
				} catch (InterruptedException e) {
					System.out.println("I was interrupted.");
					// Thread.currentThread().interrupt();
					// I know it is the whole job, so no need to re-set the
					// flag.
				}
			}
		};

		sleeper.start();
		Thread.sleep(500);
		System.out.println("Main thread woke up.");
		sleeper.interrupt();
		sleeper.join();
	}
}
