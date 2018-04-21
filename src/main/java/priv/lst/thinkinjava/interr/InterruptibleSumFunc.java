package priv.lst.thinkinjava.interr;

public class InterruptibleSumFunc {
	public static long sum(long low, long high) throws InterruptedException {
		final long CHUNK_SIZE = 1024;
		long s = 0;

		for (long i = low; i <= high; i += CHUNK_SIZE) {
			for (long j = i; j < i + CHUNK_SIZE; j++) {
				s += j;
			}
			if (Thread.interrupted()) {
				throw new InterruptedException(
						String.format("Sum calculation interrupted. Current i: %d, partial sum: %d", i, s));
			}
		}
		return s;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				try {
					long result = sum(0L, 1000000000L);
					System.out.println("Finished. Result is " + result);
				} catch (InterruptedException e) {
					System.out.println("Interrupted.");
					e.printStackTrace();
					// Thread.currentThread().interrupt();
					// I know it is the whole job, so no need to re-set the
					// flag.
				}
			}
		};

		System.out.println("Start calculating...");
		t.start();
		Thread.sleep(100);
		t.interrupt();
		t.join();
	}
}
