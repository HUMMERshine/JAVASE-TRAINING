package priv.lst.thinkinjava;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class NioTrainning {
	public static void main(String[] args) {
		intBuffer();
		try {
			program();
			byteBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void byteBuffer() throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("e:\\login2.jsp", "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(1024);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {
			System.out.println("\n-----------------------------------------");
			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}

	public static void intBuffer() {
		// 分配新的int缓冲区，参数为缓冲区容量
		// 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。
		IntBuffer buffer = IntBuffer.allocate(8);
		System.out.println("capacity : " + buffer.capacity());
		for (int i = 0; i < buffer.capacity(); ++i) {
			int j = 2 * (i + 1);
			// 将给定整数写入此缓冲区的当前位置，当前位置递增
			buffer.put(j);
		}

		// 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0
		buffer.flip();

		// 查看在当前位置和限制位置之间是否有元素
		while (buffer.hasRemaining()) {
			// 读取此缓冲区当前位置的整数，然后当前位置递增
			int j = buffer.get();
			System.out.print(j + "  ");
		}

	}

	public static void program() throws IOException {
		FileInputStream fin = new FileInputStream("e:\\login2.jsp");

		BufferedInputStream bufferStream = new BufferedInputStream(fin);
		byte[] b = new byte[1024];
		bufferStream.read(b);
		for (byte bt : b) {
			System.out.print((char) bt);
		}
		System.out.println("************");
		fin.close();
		// 创建缓冲区
		FileInputStream fins = new FileInputStream("e:\\login2.jsp");
		// 获取通道
		FileChannel fc = fins.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		// 读取数据到缓冲区
		fc.read(buffer);

		buffer.flip();

		while (buffer.remaining() > 0) {
			byte bx = buffer.get();
			System.out.print(((char) bx));
		}

		fins.close();
	}
}
