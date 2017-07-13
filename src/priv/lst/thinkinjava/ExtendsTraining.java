package priv.lst.thinkinjava;

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
}

class Fathers{
	public Fathers(){
		Print();
	}
	
	public void Print(){
		System.out.println("this is Father");
	}
}