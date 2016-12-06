package priv.lst.thinkinjava;

import org.w3c.dom.ls.LSException;

public class Count {
	private int num;
	public void count(){
		for(int i = 1; i <= 10; i++){
			num += i;
		}
		System.out.println(Thread.currentThread().getName() + "-" + num);
		System.out.println("HelloWorld");
	}
}