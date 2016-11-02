package priv.lst.thinkinjava;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
}
