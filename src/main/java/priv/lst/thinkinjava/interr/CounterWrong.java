package priv.lst.thinkinjava.interr;

public class CounterWrong {
	public static void main(String[] args) throws InterruptedException {
		Thread counter = new Thread() {
			public void run() {
				int i = 0;
				while (true) {
					System.out.println(i);
					i++;
					try {
						Thread.sleep(1000);
						/*
						 * interrupt的意思是建议线程停止。所以，正确的处理方法是停止当前的作业。
						 * 一个典型的错误是直接将会抛出InterruptException的语句用try
						 * -catch括起来，这样编译可以通过，但却是错误的处理方法。 比如这个程序
						 */
					} catch (InterruptedException e) { // WRONG!!!
						e.printStackTrace();
					}
				}
			}
		};

		counter.start();
		Thread.sleep(3500);
		counter.interrupt();
		counter.join();
	}
}