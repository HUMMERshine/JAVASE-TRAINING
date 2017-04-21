package priv.lst.thinkinjava;

import java.util.List;
import java.util.concurrent.*;

class runnable implements Runnable {
	@Override
	public void run() {

	}
}

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(1);
		/*
		 * newCacheThreadPool、newFixedThreadPool等方法，他们内部实际上都是new ThreadPoolExecutor();
		 * 下例子中最后一个参数就是定义线程达到MaxPoolSize后，又有线程到来时的策略。
		 * 使用ThreadPoolExecutetor的静态内部类来实现。
		 */
		ExecutorService service2 = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());
		
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
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return "helloworld";
			}
		});
		try {
			// service.shutdown();
			service.execute(new runnable());
			service.execute(new runnable());
			service.execute(new runnable());

			List<Runnable> list = service.shutdownNow();// 立即中断所有线程,并返回等待队列里的所有线程
			System.out.println(list);
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
