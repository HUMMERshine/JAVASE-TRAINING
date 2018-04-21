package priv.lst.thinkinjava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTraining {
	
	static class Consumer implements Runnable{
		private BlockingQueue<Integer> queue;
		
		public Consumer(BlockingQueue<Integer> queue) {
			// TODO Auto-generated constructor stub
			this.queue = queue;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true){
					if(queue.size() > 0){
						int value = queue.take();
						System.out.println(Thread.currentThread().getName() + " take one  " + value);
					}
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	static class Producer implements Runnable{
		private BlockingQueue<Integer> queue;
		
		public Producer(BlockingQueue<Integer> queue) {
			// TODO Auto-generated constructor stub
			this.queue = queue;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for(int i = 0; i < 100; i++){
					queue.put(i);
					if(i % 10 == 0)
						Thread.sleep(1000);
					//System.out.println(Thread.currentThread().getName() + " put one " + i);
					//System.out.println(queue.size());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static BlockingQueue<Integer> queue;
	private final static int size = 100;
	public static void main(String[] args) {
		queue = new ArrayBlockingQueue<Integer>(size);
		Producer producer = new Producer(queue);
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		
		new Thread(producer).start();
		new Thread(consumer1).start();
		new Thread(consumer3).start();
		new Thread(consumer2).start();
	}
	
	
}


