package priv.lst.thinkinjava;

enum Spiciness{
	NOT(1), MILD(2), MEDIUM(4), HOT(6), FLAMING(3);
	
	private int code;
	
	private Spiciness(int _code){
		this.code = _code;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.code);
		
	}
}

public class EnumTraining {
	public static void main(String[] args) {
		Spiciness hotHot = Spiciness.HOT;
		System.out.println(Spiciness.values());
		for(Spiciness sp : Spiciness.values()){
			System.out.println(sp.name() + " " + sp.ordinal() + " " + sp);
		}
		System.out.println(hotHot.name());
	}
}
