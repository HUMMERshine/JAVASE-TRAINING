package priv.lst.tij.chapter15;

import static net.mindview.util.Tuple.*;

import java.util.ArrayList;
import java.util.List;

import com.sun.swing.internal.plaf.metal.resources.metal;

import net.mindview.util.TwoTuple;

public class TupleTest {
	static TwoTuple<Integer,String> f(){
		return tuple(11, "Hello");
	}
	
	static <T> List<T> h(){
		return new ArrayList<T>();
	}
	
	static void g(TwoTuple<String, Integer> k){
		System.out.println(k);
	}
	
	static void m(List<Integer> list){
		
	}
	
	public static void main(String[] args) {
		System.out.println(f());
		//g(f());
		//m(TupleTest.h());
	}
}
