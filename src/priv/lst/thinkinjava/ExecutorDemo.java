package priv.lst.thinkinjava;

import java.util.concurrent.*;

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();

		service.execute(new Runnable() {

			@Override
			public void run() {
				int count = 10;
				while (count-- > 0) {
					System.out.println("xxxxx");
				}

			}

		});

		Thread thread = new Thread() {
			public void run() {
				int count = 10;
				while (count-- > 0) {
					System.out.println("---");
				}
			}
		};
		thread.start();

		Future<String> future = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				int count = 10;
				while (count-- > 0) {
					System.out.println("+++");
				}
				return null;
			}
		});
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		service.shutdown();
	}
}
