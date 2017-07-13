package priv.lst.thinkinjava;

public class ExceptionTraining {
	public static void main(String[] args) {
		finallyDemo();
		System.out.println(returnDemo());
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
	
	static int returnDemo(){
		int i = 0;
		try{
			i++;
			return i;
		}finally{
			i++;
			//return i;
		}
	}
}
