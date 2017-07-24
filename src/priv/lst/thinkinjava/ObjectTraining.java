package priv.lst.thinkinjava;

/*
 * instanceof 后跟的是类名。
 * isinstance 前必须是Class类。
 */
public class ObjectTraining implements Cloneable{
	public static void main(String[] args) {
		ObjectTraining obj = new ObjectTraining();
		if (obj instanceof Object) {
			System.out.println("obj is object");
		}
		
		if (obj instanceof Cloneable) {
			System.out.println("obj is Cloneable");
		}
		
		if (ObjectTraining.class.isInstance(obj)){
			System.out.println("obj is ObjectTrainingClass");
		}
		
		if (Object.class.isInstance(obj)){
			System.out.println("obj is ObjectClass");
		}
		
		if (Cloneable.class.isInstance(obj)){
			System.out.println("obj is CloneableClass");
		}
	}
}
