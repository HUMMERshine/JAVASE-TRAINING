package priv.lst.thinkinjava;

import java.io.Serializable;
import java.lang.reflect.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ReflectTraining {
	public static void main(String[] args) {
		try {
			Class<?> class1 = Class.forName("priv.lst.thinkinjava.User");
			Class<?> class2 = new User().getClass();
			Class<?> class3 = User.class;//不会初始化该类，只是加载。
			System.out.println(class1.getName());
			System.out.println(class2.getName());
			System.out.println(class3.getName());

			System.out.println(class1.getSuperclass().getName());
			System.out.println(Arrays.toString(class1.getInterfaces()));
			// System.out.println(Arrays.toString(class1.getConstructors()));

			Constructor<?> cons[] = class1.getConstructors();
			for (Constructor<?> con : cons) {
				System.out.println(Arrays.toString(con.getParameterTypes()));
			}

			Field[] fields = class1.getDeclaredFields();// 当前类内的属性
			for (Field field : fields) {
				System.out.println(field.getName() + " " + field.getModifiers() + " "
						+ Modifier.toString(field.getModifiers()) + " " + field.getType());
			}

			Field[] fields2 = class1.getFields();// 父类或者接口的属性
			for (Field field : fields2) {
				System.out.println(field.getName() + " " + field.getModifiers() + " "
						+ Modifier.toString(field.getModifiers()) + " " + field.getType());
			}

			Method[] methods = class1.getMethods();
			for (Method method : methods) {
				System.out.printf("%s ", method.getName());
			}
			System.out.println();

			Method m = class1.getMethod("setName", String.class);
			User user = new User();
			m.invoke(user, "lishutao");
			System.out.println(user.toString());

			Field field = class1.getDeclaredField("name");
			field.setAccessible(true);
			field.set(user, "Java反射机制");
			System.out.println(field.get(user));
			System.out.println(user.toString());
			
			System.out.println(List.class.getClassLoader());//null
			
			
			int[] temp = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			Class<?> arr = temp.getClass().getComponentType();
	        Object newArr = Array.newInstance(arr, 20);
	        int co = Array.getLength(temp);
	        System.arraycopy(temp, 0, newArr, 0, co);
	        System.out.println(Arrays.toString((int [])newArr));
	        
	        Thread.sleep(100000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

interface people {
	String id = "000";
	boolean sex = false;
}

class User implements Serializable, people {
	private int age;
	private String name;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public User(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}
}