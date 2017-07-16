package priv.lst.thinkinjava;

/**
 * 接口可以继承
 * 
 * @author lst-bytedance
 *
 */

interface InterfaceFather {
	// 接口中的“成员变量”会自动变为为public static final
	int value = 1;

	public void f();
}

interface InterfaceChild extends InterfaceFather {
	public void f();
}

interface InterfaceOther {
	public void f();
}

abstract class ClassFather {
	abstract void f();
}

class ClassChild implements InterfaceChild, InterfaceOther {

	@Override
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}

}

public class InterfaceTraining extends ClassFather implements InterfaceChild {
	public static void main(String[] args) {
		new ClassChild().f();
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
	}
}
