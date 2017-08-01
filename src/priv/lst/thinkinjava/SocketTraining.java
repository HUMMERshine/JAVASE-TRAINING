package priv.lst.thinkinjava;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

import com.sun.accessibility.internal.resources.accessibility;

public class SocketTraining {
	public static void main(String[] args) {
		//new Thread(new Client()).start();
		try {
			ServerSocket server = new ServerSocket(44443);
			System.out.println("本地地址是：" + InetAddress.getLocalHost().getHostAddress());
			new Thread(new Client()).start();
			
			int count = 0;
			while (true) {
				count++;
				Socket socket = server.accept();
				Thread.sleep(3000);
				System.out.println(socket.getInetAddress() + " one socket come in!");
				OutputStream output = socket.getOutputStream();
				// PrintStream print = new PrintStream(output);
				DataOutputStream print = new DataOutputStream(output);
				// print.write(("hello world" + count).getBytes("UTF-8"));
				print.write(("hello world你好" + count).getBytes("GBK"));
				// print.flush();
				print.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Client2 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
			System.out.println("hello");
			Socket socket = new Socket("127.0.0.1", 44443);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}

class Client implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*int a = 1;
		int b = 0;
		int c = a/b;*/
		try {
			while (true) {
				System.out.println("in");
				Socket socket = new Socket("127.0.0.1", 44443);
				/*
				 * BufferedReader buffer = new BufferedReader(new
				 * InputStreamReader(socket.getInputStream())); String str =
				 * buffer.readLine(); while (str != null) {
				 * System.out.println(str); str = buffer.readLine(); }
				 */
				DataInputStream input = new DataInputStream(socket.getInputStream());
				
				byte[] buf = new byte[1024];
				int readnum = 0;
				System.out.println("阻塞");
				while ((readnum = input.read(buf)) > 0) {
					System.out.println(new String(buf, "GBK"));
				}
				System.out.println("end");
				/*
				 * readnum = input.read(buf); if (readnum > 0) {
				 * System.out.println(new String(buf, "GBK"));
				 * 
				 * 
				 * }
				 */
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

