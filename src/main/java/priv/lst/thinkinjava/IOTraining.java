package priv.lst.thinkinjava;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class IOTraining {
	private String path = "/Users/lishutao/Document/";
	//private String path = "/Users/lst-bytedance/Documents/";

	public static void main(String[] args) {
		byte b = 127;
		int b2 = b;
		System.out.println(b2);
		Scanner scanner = new Scanner(System.in);

		System.out.println(scanner.nextLine());

		byte[] bb = new byte[] { 3, 2, 3 };
		System.out.println(bb.getClass().getSimpleName() + "&&&&");
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			int result;
			while ((result = isr.read()) != -1) {
				System.out.println(result);
				/*
				 * 注意回车。
				 */
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
	public void dataOutPut() {
		File list = new File(path);
		for (String string : list.list()) {
			System.out.println(string);
			if (new File(path+string).isDirectory()) {
				System.out.println(string + " is a dir!");
			}
		}
		File file = new File(path + "a.txt");
		try {
			DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(file));
			outputStream.writeUTF("hello");
			outputStream.writeInt(99);
			outputStream.writeChars("\n");
			outputStream.close();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream outputStream2 = new DataOutputStream(baos);
			outputStream2.writeUTF("hello你好");
			//outputStream2.writeInt(99);
			outputStream2.writeChars("\n");
			System.out.println(baos.toString("utf-8"));
			outputStream2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * bufferedReader
	 */
	@Test
	public void BufferedInputFile() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(path+"a.txt"));
			String s;
			StringBuilder sb = new StringBuilder();
			while ((s = in.readLine()) != null) {
				sb.append(s + '\n');
			}
			in.close();
			System.out.println(sb.toString());
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "a.txt"));
			byte [] bs = new byte[1024];
			System.out.println(bis.read(bs));
			System.out.println(new String(bs, "GBK"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//把gbk转换为utf-8使用InputStreamReader和OutputStreamWriter。
	//String在内存中是用unicode来存储的，它和gbk、utf等没有关系。
	//new String（“hello中国”.getBytes("Gbk"), "utf-8）.这是字符串转换
	//https://www.zhihu.com/question/20361462 看这个链接。
	@Test
	public void MemoryInput() {
		String s1 = "hello world 中国禹州";
		System.out.println();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path + "a.txt"), "GBK"));
			String s;
			StringBuilder sb = new StringBuilder();
			while ((s = in.readLine()) != null) {
				sb.append(s + '\n');
			}
			in.close();
			
			System.out.println(sb.toString());
			
			FileOutputStream out = new FileOutputStream(path+"b.txt");
			OutputStreamWriter ow = new OutputStreamWriter(out, "utf-8");
			BufferedWriter bw = new BufferedWriter(ow);
			bw.write(sb.toString() + s1);
			bw.close();
			ow.close();
			out.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void StringReader(){
		StringReader sr = new StringReader("hello world!");
		try {
			char [] chs = new char[100];
			System.out.println(sr.read(chs));
			System.out.println(chs);
			
			PrintWriter print2 = new PrintWriter(System.out, true);
			print2.println(chs);
			print2.close();
			
			System.out.println(Arrays.toString(chs));
			PrintWriter print = new PrintWriter(System.out);
			print.println(chs);
			print.flush();
			print.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void inputStream(){
		try {
//			FileInputStream fin = new FileInputStream(path + "a.txt");
			byte [] array = new byte[]{5, 4, 3, 2, 1};
			ByteArrayInputStream bais = new ByteArrayInputStream(array);
			byte [] bs = new byte[1024];
			System.out.println(bais.available());
			int len = bais.read();
			System.out.println(bais.available());
			System.out.println(Arrays.toString(bs));
			System.out.println(len);
//			System.out.println(bs.length);
//			while (len != -1) {
//				len = bais.read(bs);
//				System.out.println(len);
//				System.out.println(bs.length);
//			}
//			for(int i = 0; i < len; i++){
//				System.out.println(bs[i] + " " + (char)bs[i]);
//			}
			bais.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void outputStream(){
		try {
//			FileInputStream fin = new FileInputStream(path + "a.txt");
			byte [] array = new byte[8];
			array[0] = 1;
			array[1] = 2;
			byte [] array2 = new byte[8];
			array2[0] = 1;
			array2[1] = 2;
			ByteArrayOutputStream bais = new ByteArrayOutputStream();
			bais.write(array);
			bais.write(array2);
			byte [] result = bais.toByteArray();
			System.out.println(result.length);
			for (byte b : result) {
				System.out.println(b);
			}
			bais.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
