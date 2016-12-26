package priv.lst.thinkinjava;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;


public class IOTraining {
	public static void main(String[] args) {
		byte [] bb = new byte[]{3,2,3};
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			int result;
			while((result = isr.read()) != -1){
				System.out.println(result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * DataOutPutStream 联系
	 */
	@Test
	public void dataOutPut(){
		File file = new File("/Users/lishutao/a.txt");
		try {
			DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file));
			outputStream.writeUTF("hello");
			outputStream.writeInt(99);
			outputStream.writeChars("\n");
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * bufferedReader
	 */
	@Test
	public String BufferedInputFile(){
		try {
			BufferedReader in = new BufferedReader(new FileReader("/Users/lishutao/Documents/a.txt"));
			String s;
			StringBuilder sb = new StringBuilder();
			while((s = in.readLine()) != null){
				sb.append(s + '\n');
			}
			in.close();
			System.out.println(sb.toString());
			return sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return null;
	}
	
	public void MemoryInput(){
		
	}
}
