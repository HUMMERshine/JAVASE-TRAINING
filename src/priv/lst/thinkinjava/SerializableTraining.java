package priv.lst.thinkinjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTraining implements Serializable {
	
	private int i;
	private String s;
	
	public SerializableTraining(int i, String s){
		this.i = i;
		this.s = s;
	}
	
	public static void main(String[] args) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/lishutao/code/java/seri.out"));
			out.writeObject("hello world");
			out.writeObject(new SerializableTraining(100, "LISHUTAO"));
			out.writeInt(1000);
			out.flush();//如果不进行刷新，最后一个1000不会写入文件。
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/lishutao/code/java/seri.out"));
			String string = (String)in.readObject();
			SerializableTraining ser = (SerializableTraining)in.readObject();
			int num = in.readInt();
			System.out.println(string);
			System.out.println(ser);
			System.out.println(num);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "i:" + i + "s:" + s;
	}
}
