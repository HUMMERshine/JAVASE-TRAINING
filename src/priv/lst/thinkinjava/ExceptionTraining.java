package priv.lst.thinkinjava;

public class ExceptionTraining {
	public static void main(String[] args) {
		finallyDemo();
	}
	
	static Object finallyDemo(){
		try{
			int i = 1;
			int k = 2 / i;
			return null;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("xxxxx");
		}
		return null;
	}
}
