package priv.lst.thinkinjava;

public class OperateTraining {
	public static void main(String[] args) {
		int x = 100;
		/*
		 * 三目运算必须有左值。
		 */
		x = (x > 101) ?  1 : 2;
		/*
		 * x>0?1:x<0?-1:0 等价于 x>0?1:(x<0?-1:0)
		 * 右结合的。
		**/ 
		 
	}
}
