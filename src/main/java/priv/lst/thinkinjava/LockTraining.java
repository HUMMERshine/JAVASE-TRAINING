package priv.lst.thinkinjava;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockTraining {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	private Lock lock = new ReentrantLock(); // 注意这个地方

	public static void main(String[] args) {
		final LockTraining test = new LockTraining();

		Thread t1 = new Thread() {
			public void run() {
				try {
					test.insert(Thread.currentThread());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		};
		t1.start();

		Thread t2 = new Thread() {
			public void run() {
				try {
					test.insert(Thread.currentThread());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		};
		t2.start();
		try {
			Thread.sleep(1000);
			t2.interrupt();
			System.out.println("中断了吗？");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insert(Thread thread) throws Exception {
		// if (lock.tryLock()) {
		/*
		 * lockInterruptibly()方法可以响应中断。
		 */
		try{
			lock.lockInterruptibly();
		}catch (InterruptedException e){
			e.printStackTrace();
			System.out.println(Thread.currentThread().getName() + "中断了!");
			throw new Exception(e);
		}
		/*
		 * lock()和tryLock()方法不能够响应中断，但是tryLock(long time, TimeUnit unit)可以响应中断，在time时间内阻塞的。
		 */
		//lock.lock(); 
		try {
			System.out.println(thread.getName() + "得到了锁");
			Thread.sleep(5000);
			for (int i = 0; i < 5; i++) {
				arrayList.add(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println(thread.getName() + "释放了锁");
			lock.unlock();
		}
		/*
		 * } else { System.out.println(thread.getName() + "获取锁失败"); }
		 */
	}
}
