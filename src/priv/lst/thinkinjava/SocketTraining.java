package priv.lst.thinkinjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTraining {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(44443);
			System.out.println(InetAddress.getLocalHost().getHostAddress());
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						while (true) {
							Thread.sleep(1000);
							Socket socket = new Socket("127.0.0.1", 44443);

							BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							String str = buffer.readLine();
							while (str != null) {
								System.out.println(str);
								str = buffer.readLine();
							}
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}).start();
			int count = 0;
			while (true) {
				count++;
				Socket socket = server.accept();
				OutputStream output = socket.getOutputStream();
				PrintWriter print = new PrintWriter(output);
				print.print("hello world" + count);
				print.flush();
				print.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
