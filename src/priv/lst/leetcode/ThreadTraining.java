package priv.lst.leetcode;

public class ThreadTraining {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i = 0; i < 10; i++){
					System.out.println(i);
				}
				
			}
		}).start();
	}
}
