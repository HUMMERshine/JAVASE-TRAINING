package priv.lst.thinkinjava;

public class InnerClass {
	private int age = 99;
    String name = "Coco";
    public class Inner{
        String name = "Jayden";
        public void show(){
            System.out.println(InnerClass.this.name);//访问外部类对象的实例和方法。
            System.out.println(name);
            System.out.println(age);
        }
    }
    public Inner getInnerClass(){
        return new Inner();
    }
    public void showIt(){
    	//this.new Inner().show();
    	new Inner().show();
    }
    public static void main(String[] args){
    	InnerClass o = new InnerClass();
    	Inner in = o.new Inner();
        in.show();
    }
}
