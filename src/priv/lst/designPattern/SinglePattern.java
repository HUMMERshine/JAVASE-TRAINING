package priv.lst.designPattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 静态内部类实现方式（也是一种懒加载方式） 这种方式：线程安全，调用效率高，并且实现了延迟加载 解决反射和反序列化漏洞
 * 
 * @author Shearer
 *
 */
public class SinglePattern implements Serializable {

	/*
	 * 静态内部类，在成员被使用时才会加载和初始化。
	 */
	private static class SingletonClassInstance {
		private static final SinglePattern instance = new SinglePattern();
	}

	// 方法没有同步，调用效率高
	public static SinglePattern getInstance() {
		return SingletonClassInstance.instance;
	}

	// 防止反射获取多个对象的漏洞
	private SinglePattern() {
		if (null != SingletonClassInstance.instance)
			throw new RuntimeException();
	}

	// 防止反序列化获取多个对象的漏洞
	private Object readResolve() throws ObjectStreamException {
		return SingletonClassInstance.instance;
	}

}
