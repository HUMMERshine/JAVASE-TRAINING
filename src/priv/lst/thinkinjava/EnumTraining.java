package priv.lst.thinkinjava;

enum Spiciness{
	NOT(1), MILD(2), MEDIUM(4), HOT(6), FLAMING(3);
	
	private int code;
	
	private Spiciness(int _code){
		this.code = _code;
		System.out.println("i am " + code);
	}
	
	@Override
	public String toString(){
		return String.valueOf("String " + this.code);
		
	}
}

public class EnumTraining{
	public static void main(String[] args) {
		System.out.println(Child.x);//通过子类调用父类的静态变量和方法不会造成子类初始化
		Spiciness hotHot = Spiciness.HOT;
		System.out.println(Spiciness.values());
		for(Spiciness sp : Spiciness.values()){
			System.out.println(sp.name() + " " + sp.ordinal() + " " + sp + " " + sp.compareTo(hotHot));
		}
		System.out.println(hotHot.name());
		System.out.println(Enum.valueOf(Spiciness.class, "HOT"));
	}
}




class Father{
	public static int x = 5;
	static {
		System.out.println("i am father");
	}
	public static void getit(){}
}

class Child extends Father{
	static {
		System.out.println("i am son");
	}
}

