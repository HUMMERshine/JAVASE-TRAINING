package priv.lst.thinkinjava.interr;

/*
 * 中断是通过调用Thread.interrupt()方法来做的. 这个方法通过修改了被调用线程的中断状态来告知那个线程, 说它被中断了. 
 * 对于非阻塞中的线程, 只是改变了中断状态, 即Thread.isInterrupted()将返回true; 对于可取消的阻塞状态中的线程, 
 * 比如等待在这些函数上的线程, Thread.sleep(), Object.wait(), Thread.join(), 这个线程收到中断信号后, 
 * 会抛出InterruptedException, 同时会把中断状态置回为false.
 * http://blog.csdn.net/sunxing007/article/details/9123363
 */
class InterruptibleSumCalculator implements Runnable {
	private long low;
	private long high;

	private boolean finished = false;
	private long result = 0;

	public InterruptibleSumCalculator(long low, long high) {
		this.low = low;
		this.high = high;
	}

	@Override
	public void run() {
		final long CHUNK_SIZE = 1024;
		long s = 0;

		for (long i = low; i <= high; i += CHUNK_SIZE) {
			for (long j = i; j < i + CHUNK_SIZE; j++) {
				s += j;
			}
			/*
			 * 
			 * 中断状态可以通过 Thread.isInterrupted()来读取，并且可以通过一个名为 Thread.interrupted()
			 * 的静态方法读取和清除状态(即调用该方法结束之后, 中断状态会变成false)。
			 * isInterrupted()不是静态的，不会清除中断状态；
			 * nterrupted()是静态的，会清除中断状态；
			 */
			if(Thread.currentThread().isInterrupted())
				System.out.println("interruped() 方法前的状态：" + Thread.currentThread().isInterrupted());
			
			if (Thread.interrupted()) {
				System.out.println("interruped() 方法后的状态：" + Thread.currentThread().isInterrupted());
				
				System.out.format("Sum calculation interrupted.\nCurrent i: %d, partial sum: %d\n", i, s);
				//System.out.println(Thread.interrupted());
				result = s;
				Thread.currentThread().interrupt(); // re-set the interrupted flag.
													// 该出复位中断状态，因为该状态可能会被其他线程使用。
				// Maybe this calculator is part of a bigger job.
				// I'll come back to this issue later.
				return;
			}
		}
		finished = true;
		result = s;
	}

	public boolean isFinished() {
		return finished;
	}

	public long getResult() {
		return result;
	}
}

public class InterruptibleSum {
	public static void main(String[] args) throws InterruptedException {
		InterruptibleSumCalculator isc = new InterruptibleSumCalculator(0L, 100000000000L);

		Thread t = new Thread(isc);

		System.out.println("Start calculating...");
		t.start();
		System.out.println("Waiting for it to finish...");
		t.join(1000);

		if (t.isAlive()) {
			System.out.println("Still alive. Try to interrupt it...");
			t.interrupt();
			System.out.println("Waiting for it to die...");
			t.join();
		} else {
			System.out.println("Already dead.");
		}

		System.out.format("Finished? %s\nResult: %d\n", isc.isFinished(), isc.getResult());

	}
}
