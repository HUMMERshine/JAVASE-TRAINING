package priv.lst.thinkinjava;

import java.util.List;
import java.util.concurrent.*;

class runnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

public class ExecutorDemo {
	public static void main(String[] args) {
		System.out.println("main" + Thread.currentThread().getName());
		ExecutorService service2 = Executors.newFixedThreadPool(1);
		/*
		 * newCacheThreadPool、newFixedThreadPool等方法，他们内部实际上都是new ThreadPoolExecutor();
		 * 下例子中最后一个参数就是定义线程达到corePoolSize，并且队列也满了，而且数量也到达了MaxPoolSize
		 * 又有线程到来时的策略---->抛回给main线程（调用的线程）去处理。
		 * 使用ThreadPoolExecutetor的静态内部类来实现。
		 */
		ExecutorService service = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());
		
		/*
		 * 自定义newFixedThreadPool()。
		 */
		ExecutorService service3 = new ThreadPoolExecutor(10, 10,
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
		FutureTask ft = new FutureTask<>(new Callable<String>(){

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				int count = 10;
				while(count-- > 0){
					System.out.println("=========");
				}
				return "futuretask return";
			}
			
		});
		/*
		 * FutureTask 实现了runnable接口也实现了future接口，因此可以使用execute（）方法，也可以有返回值。
		 */
		service.execute(ft);
		try {
			System.out.println(ft.get(10, TimeUnit.SECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
			
			service.execute(new runnable());
			service.execute(new runnable());
			service.execute(new runnable());

			service.shutdown();
			if(service.awaitTermination(1, TimeUnit.SECONDS)){
				System.out.println("close it!");
			}
			
			//List<Runnable> list = service.shutdownNow();// 立即中断所有线程,并返回等待队列里的所有线程
			//System.out.println(list);
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
