package priv.lst.thinkinjava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorTraining {
	/**
	 * @author lst
	 * ThreadPool、fixPool
	 * 
	 */
	public static void main1(){
		Server server = new Server();
		for(int i = 1; i <= 100; i++){
			Task task = new Task("task" + i);
			server.executeTask(task);
		}
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***" +server.getExecutor().getPoolSize() + "***" + server.getExecutor().getActiveCount());
		server.endServer();
		try {
			while(!server.getExecutor().awaitTermination(1, TimeUnit.SECONDS)){
				System.out.println("线程没有关闭");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @author lst
	 * Callable使用
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void main2() throws ExecutionException, InterruptedException{
		ExecutorService executor = Executors.newFixedThreadPool(5);
		List<Future> list = new ArrayList<>();
		for(int i = 1; i <= 5; i++){
			Callable task = new MyCallable("task" + i);
			Future<String> f = executor.submit(task);
			list.add(f);
		}
		
		executor.shutdown();
		
		for(Future f : list){
			System.out.println(f.get().toString());
		}
		
		
	}
	public static void main(String[] args) {
		//main1();
		try {
			main2();
		} catch (ExecutionException e) {
			System.out.println("lst");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Server{
	private ThreadPoolExecutor executor;
	
	public Server(){
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);//固定大小线程池
		//executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public ThreadPoolExecutor getExecutor(){
		return executor;
	}
	
	public void executeTask(Task task){
		System.out.println("Server: A new task has arrived");
		executor.execute(task);
		System.out.printf("Server: pool Size : %d\n", executor.getPoolSize());
		System.out.println("Server: active Count: " + " " + executor.getActiveCount());
		System.out.println("Server: Completed Tasks: " + executor.getCompletedTaskCount());
	}
	
	public void endServer(){
		executor.shutdown();
		
	}
}

class Task implements Runnable{

	private Date initDate;
	private String name;
	
	public Task(String name){
		this.name = name;
		initDate = new Date();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s:Task %s: Created on : %s\n", Thread.currentThread().getName(), name, initDate);
		System.out.printf("%s:Task %s: Started on : %s\n", Thread.currentThread().getName(), name, new Date());
		
		try{
			Long duration = (long) (Math.random() * 10);
			System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
			TimeUnit.SECONDS.sleep(duration);
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.printf("%s:Task %s: Finished on : %s\n", Thread.currentThread().getName(), name, new Date());

	}
	
}

class MyCallable implements Callable{
	private String taskNum;
	
	public MyCallable(String taskNum){
		this.taskNum = taskNum;
	}
	
	@Override
	public Object call() throws Exception {
		System.out.println(">>>" + taskNum + "任务启动");
		Date dateTmp1 = new Date();
		long l = (long) (Math.random() * 1000);
		Thread.sleep(l);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>"+taskNum+"任务终止");
		if(l > 800) throw new Exception("hello world");
		return taskNum +"任务返回结果，运行时间为" + time +"毫秒";
	}
	
}
