package priv.lst.thinkinjava;

public class AbstractClassTraining extends A{
	
	public static void main(String[] args) {
		A ab = new AbstractClassTraining();
		ab.method2();
	}
	
	@Override
	void method() {
		// TODO Auto-generated method stub
		
	}
	
	public Integer method2(){
		//覆盖父类的方法时返回值必须一样,或者小于父类。
		System.out.println("i am in AbstractClassTraining");
		return 1;
	}
}
/*
 * 抽象类里的抽象方法必须加abstract修饰符;
 * 接口内的方法都是抽象的，因此不用加abstract修饰符;
 */
abstract class A{
	 abstract void method();
	 
	 public Object method2(){
		 System.out.println("i am in A");
		 return new Object();
	 }
}

interface B{
	void method1();
}