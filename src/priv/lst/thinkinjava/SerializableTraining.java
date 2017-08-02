package priv.lst.thinkinjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class SerializableTraining implements Serializable {
	// private static String path = "/Users/lishutao/";
	private static String path = "/Users/lst-bytedance/";

	/*
	 * 如果不加这个uid，前期序列化seri.out后，后期在类内增加一个变量val，这时再解序列化就会发生错误。
	 * 如果添加这个uid，那么后期及时类变化了也会正常解序列化，只是多出来的那个变量 或
	 * 新增的变量会丢失而已。另外序列化为深复制，解序列化也不需要调用构造函数
	 */
	private final static long serialVersionUID = 1L;

	//private String i;
	private int i;
	private String s;
	private final int val = 2;
	private static String tt; //静态成员不可以序列化

	public SerializableTraining(int i, String s) {
		//this.i = new Integer(i).toString();
		this.i = i;
		this.s = s;
		System.out.println("this is constructor!");
	}

	public static void main(String[] args) {
		try {
			//serializable();
			unserializable();
			/*
			 * ObjectOutputStream out = new ObjectOutputStream(new
			 * FileOutputStream(path + "code/java/seri.out")); out.writeObject(
			 * "hello world"); out.writeObject(new SerializableTraining(100,
			 * "LISHUTAO")); out.writeInt(1000);
			 * out.flush();//如果不进行刷新，最后一个1000不会写入文件。
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void serializable() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path + "code/java/seri.out"));
		out.writeObject("hello world");
		SerializableTraining st = new SerializableTraining(100, "LISHUTAO");
		st.tt = "lst";
		out.writeObject(st);
		out.writeInt(1000);
		out.flush();// 如果不进行刷新，最后一个1000不会写入文件。
		System.out.println(st);
	}

	public static void unserializable() throws IOException, ClassNotFoundException {

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path + "code/java/seri.out"));
		String string = (String) in.readObject();
		SerializableTraining ser = (SerializableTraining) in.readObject();
		int num = in.readInt();
		System.out.println(string);
		System.out.println(ser);
		System.out.println(num);
		System.out.println(ser.tt);	//stati变量不能序列化，不保存tt的值。
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "i:" + i + "s:" + s;
	}

	@Test
	public void testSerUID() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path + "code/java/seri.out"));
			String string = (String) in.readObject();
			SerializableTraining ser = (SerializableTraining) in.readObject();
			int num = in.readInt();
			System.out.println(string);
			System.out.println(ser);
			System.out.println(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
