package priv.lst.thinkinjava;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.*;

public class SelectTraining {

	private static int port = 44443;
	private Selector selector;
	
	public static void main(String[] args) {
		SelectTraining st = new SelectTraining();
		try {
			st.getSelector();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
					System.out.println("hello");
					Socket socket = new Socket("127.0.0.1", port);
					DataInputStream di = new DataInputStream(socket.getInputStream());
					byte[] buf = new byte[1024];
					int readnum = 0;
					while ((readnum = di.read(buf)) > 0) {
						System.out.println(new String(buf, "GBK"));
					}
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
		}).start();
		st.listen();
		
	}
	
	/*
	 * 注册事件
	 */
	protected Selector getSelector() throws IOException {
		// 创建Selector对象
		this.selector = Selector.open();

		// 创建可选择通道，并配置为非阻塞模式
		ServerSocketChannel server = ServerSocketChannel.open();
		server.configureBlocking(false);

		// 绑定通道到指定端口
		ServerSocket socket = server.socket();
		InetSocketAddress address = new InetSocketAddress(port);
		socket.bind(address);

		// 向Selector中注册感兴趣的事件
		server.register(selector, SelectionKey.OP_ACCEPT);
		return selector;
	}

	/*
	 * 开始监听
	 */
	public void listen() {
		System.out.println("listen on " + port);
		try {
			while (true) {
				// 该调用会阻塞，直到至少有一个事件发生
				selector.select();
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iter = keys.iterator();
				while (iter.hasNext()) {
					SelectionKey key = (SelectionKey) iter.next();
					iter.remove();
					process(key);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 根据不同的事件做处理
	 */
	protected void process(SelectionKey key) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		// 接收请求
		if (key.isAcceptable()) {
			System.out.println("accept");
			ServerSocketChannel server = (ServerSocketChannel) key.channel();
			SocketChannel channel = server.accept();
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ);
		}
		// 读信息
		else if (key.isReadable()) {
			System.out.println("read");

			SocketChannel channel = (SocketChannel) key.channel();
			int count = channel.read(buffer);
			if (count > 0) {
				buffer.flip();
				CharBuffer charBuffer = Charset.forName("UTF-8").newDecoder().decode(buffer);
				String name = charBuffer.toString();
				SelectionKey sKey = channel.register(selector, SelectionKey.OP_WRITE);
				sKey.attach(name);
			} else {
				channel.close();
			}
			buffer.clear();
		}
		// 写事件
		else if (key.isWritable()) {
			System.out.println("write");

			SocketChannel channel = (SocketChannel) key.channel();
			String name = (String) key.attachment();

			ByteBuffer block = Charset.forName("UTF-8").encode(CharBuffer.wrap("Hello " + name));
			if (block != null) {
				channel.write(block);
			} else {
				channel.close();
			}

		}
	}
}
