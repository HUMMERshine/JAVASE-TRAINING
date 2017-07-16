package priv.lst.thinkinjava.interr;

import org.junit.Test;

class Thread1 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (Thread.interrupted()) {
				System.out.println("Someone interrupted me.");
			} else {
				System.out.println("Going...");
			}
			long now = System.currentTimeMillis();
			while (System.currentTimeMillis() - now < 1000) {
				// 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
				// 此处用这种方法空转1秒
			}
		}
	}
}

class Thread2 extends Thread {
	Thread parent;
	public Thread2(Thread parent){
		this.parent = parent;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (Thread.interrupted()) {
				System.out.println("Someone interrupted me.");
			} else {
				System.out.println("Going...");
			}
			long now = System.currentTimeMillis();
			while (System.currentTimeMillis() - now < 2000) {
				// 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
				// 此处用这种方法空转1秒
			}
			parent.interrupt();
		}
	}
}

class MyThread extends Thread {
	public MyThread(String name){
		super(name);
	}
	
    @Override
    public void run() {
        try{
            for (int i = 0; i < 50000000; i++) {
                if (Thread.interrupted()) {
                    System.out.println("should be stopped and exit");
                    throw new InterruptedException();
                }
                //System.out.println("i=" + (i + 1));
            }
            System.out.println("this line cannot be executed. cause thread throws exception");
        }catch(InterruptedException e){
            /**这样处理不好
             * System.out.println("catch interrupted exception");
             * e.printStackTrace();
             */
        	System.out.println("lst" + Thread.currentThread().getName());
        	
             Thread.currentThread().interrupt();//这样处理比较好
        }
    }
}

public class InterruptTraininig {
	public static void main(String[] args) throws InterruptedException {
		/*Thread t = new Thread1();

		t.start();
		Thread.sleep(3000);
		t.interrupt();*/
		/*Thread t = new Thread2(Thread.currentThread());
		t.start();  
        try {  
            t.join();  //主线程阻塞了，这时收到中断异常（子线程发出的），就会抛出异常。
        } catch (InterruptedException e) {  
            System.out.println("Parent thread will die...");  
        } */ 
        
        try {
            MyThread thread = new MyThread("xxxx");
            thread.start();
            Thread.sleep(20);
            thread.interrupt();//请求中断MyThread线程
        } catch (Exception e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
        
	}

}
