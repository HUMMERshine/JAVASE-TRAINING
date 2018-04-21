package priv.lst.thinkinjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ExceptionTraining {
	public static void main(String[] args) {
		finallyDemo();
		System.out.println(returnDemo());
	}
	
	static Object finallyDemo(){
		File file = new File("/Users/lst-bytedance/dump/exception.txt");
		PrintStream stream = null;
		try{
			stream = new PrintStream(new FileOutputStream(file));
			int i = 0;
			int k = 2 / i;
			return null;
		}catch(Exception e){
			e.printStackTrace(stream);
		}finally {
			System.out.println("xxxxx");
		}
		return null;
	}
	
	static int returnDemo(){
		int i = 0;
		try{
			i++;
			return i;
		}finally{
			i++;
			//return i;
		}
	}
}
