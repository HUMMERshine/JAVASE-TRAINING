package priv.lst.thinkinjava;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycleBarrierDemo {
	public static void main(String[] args) {
		Matrix matrix = new Matrix(10000, 1000, 5);
		Result data = new Result(10000);
		Searcher [] searchers = new Searcher[5];
		Group group = new Group(data);
		/*在集合点同步*/
		CyclicBarrier barrier = new CyclicBarrier(5, group);//等待5个线程await，之后进行group线程。
		/*
		 CountDownLatch cdl = new CountDownLatch(10);  
		 定义一个计数器初始值为10，
		 cdl.await(); 某个线程run()中调用该方法，进行阻塞
		运行到这个方法时这个线程将阻塞。
		通过调用cdl.countDown(),使该计数器减一。
		当执行了10次该方法（发生了10次这个时间），此时计数器为0 ，cdl就唤醒所有等待的线程。
		 这就是“等待多个并发事件的完成”。
		 */
		for(int i = 0; i < 5; i++){
			searchers[i] = new Searcher(data, barrier, i*2000, (i+1)*2000, 5, matrix);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		System.out.println("main is down!");
	}
}

class Searcher implements Runnable{
	CyclicBarrier barrier;
	int firstRow;
	int lastRow;
	int number;
	Matrix matrix;
	Result result;
	public Searcher(Result result, CyclicBarrier barrier, int firstRow, int lastRow, int number, Matrix matrix){
		this.barrier = barrier;
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.number = number;
		this.matrix = matrix;
		this.result = result;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int counter;
		System.out.println(Thread.currentThread().getName()+":processing lines from" + firstRow + "to" + lastRow);
		for(int i = firstRow; i < lastRow; i++){
			int row[] = matrix.getRow(i);
			counter = 0;
			for(int j = 0; j < row.length; j++){
				if(row[j] == number){
					counter++;
				}
			}
			result.setData(i, counter);
		}
		try {
			barrier.await();//记得await()，阻塞线程当阻塞的线程达到定义参数（5个）个的时候,线程继续进行，并执行定义时参数里的另一个线程（group）
			System.out.println("****" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

class Matrix {
	private int [][] data;
	public Matrix(int size, int length, int number){
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j<length; j++){
				data[i][j] = random.nextInt(10);
				if(data[i][j] == number){
					counter++;
				}
			}
		}
		System.out.println("there are " + counter +"ccurrences" + number +"in data");
	}
	public int [] getRow(int row){
		if(row >=0 && row < data.length){
			return data[row];
		}
		return null;
	}
}

class Result{
	int [] result;
	public Result(int size){
		result = new int[size]; 
	}
	public void setData(int position , int value){
		result[position] = value;
	}
	
	public int [] getData(){
		return result;
	}
}

class Group implements Runnable{
	Result result;
	public Group(Result result){
		this.result = result;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int data [] = result.getData();
		int finalResult = 0;
		for(int number : data){
			finalResult += number;
		}
		
		System.out.println("final result is : " + finalResult);
	}
	
}







