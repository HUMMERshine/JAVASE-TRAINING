package priv.lst.thinkinjava;

import java.util.PriorityQueue;

import java.util.LinkedList;

public class WaitSignalTraining {
	private int queueSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

	public static void main(String[] args) {
		WaitSignalTraining cap = new WaitSignalTraining();
		Consumer cus = cap.new Consumer();
		Producer pro = cap.new Producer();
		Thread cusT = new Thread(cus);
		Thread proT = new Thread(pro);
		Thread proT2 = new Thread(pro);

		proT.start();
		//proT2.start();
		cusT.start();
		Thread cusT1 = new Thread(cus);
		Thread cusT2 = new Thread(cus);
		cusT1.start();
		cusT2.start();
	}

	/**
	 * 消费者 com.subject01.CusAndPro.java
	 * 
	 * @author 孙涛 2016年5月10日
	 */
	class Consumer implements Runnable {

		@Override
		public void run() {
			cousume();
		}

		private void cousume() {
			while (true) {
				synchronized (queue) {
					while (queue.size() == 0) {
						try {
							System.out.println("队列空，等待数据。。。");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							queue.notify();
						}
					}

					queue.poll();
					queue.notifyAll();
					System.out.println(Thread.currentThread().getName() + "从队列中取走一个元素，队列中剩余" + queue.size() + "个");
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 生产者 com.subject01.CusAndPro.java
	 * 
	 * @author 孙涛 2016年5月10日
	 */
	class Producer implements Runnable {
		private int count = 100;
		@Override
		public void run() {
			produce();
		}

		private void produce() {
			while (count-- > 0 ) {
				synchronized (queue) {
					while (queue.size() == queueSize) {
						try {
							System.out.println("队列已满，等待空余的空间");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							queue.notify();
						}
					}

					queue.offer(1); // 每次插入一个元素
					queue.notify();
					System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
				}
			}
		}

	}
}
