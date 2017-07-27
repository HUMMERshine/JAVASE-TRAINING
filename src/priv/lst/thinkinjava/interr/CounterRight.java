package priv.lst.thinkinjava.interr;

public class CounterRight {
	public static void main(String[] args) throws InterruptedException {
		Thread counter = new Thread() {
			public void run() {
				int i = 0;
				try {
					while (true) {
						System.out.println(i);
						i++;
						Thread.sleep(1000);// 正确的做法是停止运行
					}
				} catch (Exception e) {
					System.out.println("Counter interrupted. Stop.");
					// Thread.currentThread().interrupt();
					// I know it is the whole job, so no need to re-set the
					// flag.
				}
			}
		};

		counter.start();
		Thread.sleep(3500);
		counter.interrupt();
		counter.join();
	}
}