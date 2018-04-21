package priv.lst.thinkinjava;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	private static final int size = 100;
	public static void main(String[] args) {
		FileMock mock = new FileMock(1000, 10);
		Buffer buffer = new Buffer(20);
		Producer producer = new Producer(mock, buffer);
		Thread threadProducer = new Thread(producer, "producer");
		Consumer consumers[] = new Consumer[size];
		Thread[] threadConsumer = new Thread[size];
		for (int i = 0; i < size; i++) {
			consumers[i] = new Consumer(buffer);
			threadConsumer[i] = new Thread(consumers[i], "consumer" + i);
		}
		threadProducer.start();
		for (int i = 0; i < size; i++) {
			threadConsumer[i].start();
		}
	}
}

class FileMock {
	private String content[];
	private int index;

	public FileMock(int size, int length) {
		content = new String[size];
		for (int i = 0; i < size; i++) {
			StringBuilder buffer = new StringBuilder(length);
			for (int j = 0; j < length; j++) {
				int indice = (int) Math.random() * 255;
				buffer.append((char) index);
			}
			content[i] = buffer.toString();
		}
		index = 0;
	}

	public boolean hasMoreLines() {
		return index < content.length;
	}

	public String getLine() {
		if (this.hasMoreLines()) {
			System.out.println("Mock :" + (content.length - index));
			return content[index++];
		}
		return null;
	}
}

class Buffer {
	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;

	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}

	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Line: %d\n",
					Thread.currentThread().getName(), buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String get() {
		String line = null;
		lock.lock();
		try {
			while ((buffer.size() == 0) && (hasPendingLines())) {
				lines.await();
			}
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Reader: %d\n",
						Thread.currentThread().getName(), buffer.size());
				space.signalAll();
				//lines.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
		return line;
	}

	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}

	public boolean hasPendingLines() {
		return this.pendingLines || buffer.size() > 0;
	}
}

class Producer implements Runnable {

	private FileMock mock;
	private Buffer buffer;

	public Producer(FileMock mock, Buffer buffer) {
		this.mock = mock;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		buffer.setPendingLines(true);
		while (mock.hasMoreLines()) {
			String line = mock.getLine();
			buffer.insert(line);
		}
		System.out.println("*************");
		buffer.setPendingLines(false);
	}

}

class Consumer implements Runnable {
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			//Thread t  = Thread.currentThread();
			//t.yield();
			processLine(line);
		}
	}

	public void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
