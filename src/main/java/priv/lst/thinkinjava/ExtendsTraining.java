package priv.lst.thinkinjava;

import java.io.IOException;
import java.util.ArrayList;

class Fathers{
	public Fathers(){
		Print();
	}
	
	public void Print(){
		System.out.println("this is Father");
	}
	
	public ArrayList testReturn(){
		return new ArrayList<>();
	}
	
	public void testException() throws IOException{
		
	}
	
	public void testAuthority(){
		
	}
 }
/**
 * 当子类和父类都有同一个函数时，如果子类构造器或父类构造器内调用该函数的话优先调用子类的函数。
 * @author lst-bytedance
 *
 */
public class ExtendsTraining extends Fathers{
	public ExtendsTraining() {
		// TODO Auto-generated constructor stub
		Print();
	}
	
	public static void main(String[] args) {
		new ExtendsTraining();
	}
	
	public void Print(){
		System.out.println("this is child");
	}
	
	/*
	 * (non-Javadoc)
	 * @see priv.lst.thinkinjava.Fathers#testReturn()
	 * 返回值不可以是List，只能是ArrayList及其子类。
	 */
	public ArrayList testReturn(){
		
		return new ArrayList<>();
	}
	
	/*
	 * (non-Javadoc)
	 * @see priv.lst.thinkinjava.Fathers#testException()
	 * 改异常类型只能是父类异常---IOException或者其子类异常。
	 * 
	 */
	public void testException() throws IOException{
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see priv.lst.thinkinjava.Fathers#testAuthority()
	 * 改权限只能是public ，因为父类的权限是public，子类只能比父类大。
	 */
	public void testAuthority(){
		
	}
}

