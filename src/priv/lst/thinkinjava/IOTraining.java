package priv.lst.thinkinjava;

import java.io.*;

import java.util.Scanner;

import org.junit.Test;

public class IOTraining {
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
		File list = new File(".");
		for (String string : list.list()) {
			System.out.println(string);
		}
		File file = new File("/Users/lishutao/a.txt");
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
			BufferedReader in = new BufferedReader(new FileReader("/Users/lishutao/Documents/a.txt"));
			String s;
			StringBuilder sb = new StringBuilder();
			while ((s = in.readLine()) != null) {
				sb.append(s + '\n');
			}
			in.close();
			System.out.println(sb.toString());
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
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/lishutao/Documents/a.txt"), "GBK"));
			String s;
			StringBuilder sb = new StringBuilder();
			while ((s = in.readLine()) != null) {
				sb.append(s + '\n');
			}
			in.close();
			
			System.out.println(sb.toString());
			
			FileOutputStream out = new FileOutputStream("/Users/lishutao/Documents/b.txt");
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
}
