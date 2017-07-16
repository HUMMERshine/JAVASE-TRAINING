package priv.lst.thinkinjava;

import java.util.*;

import net.mindview.util.PPrint;
/*
 * Collection 可以插入空对象。
 */
public class CollectionTraining {
	public static void main(String[] args) {
		list();
		linkedList();
		set();
		map();
		queue();
	}
	
	public static void list(){
		ArrayList list = new ArrayList<Integer>();
		list.add(null);
		System.out.println(list.size());
		
		int [] array = {1, 2, 4};
		Integer [] array2 = new Integer[3];
		array2[0] = 1;
		array2[1] = 2;
		array2[2] = 3;
		Collections.addAll(list, array);//array是int类型的，把这个数组整体当做元素存入list里。
		System.out.println(list.size());
		System.out.println(array);
		PPrint.pprint(list);
		Collections.addAll(list, array2);
		System.out.println(list.size());
		PPrint.pprint(list);
		
		/*
		 * asList返回的list是一个长度固定的List,不可以增加和删除，只能查询和修改。
		 */
		List list2 = Arrays.asList(1, 2, 3, 4);
		try {
			list2.add(5);
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("exception");
		}
		list2.set(1, 5);
		try {
			list2.remove(3);
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("exception");
		}
		System.out.println(list2);
	}
	
	public static void linkedList() {
		LinkedList<Integer> list = new LinkedList<>();
		Collections.addAll(list, 1, 2, 3, 4, 5);
		PPrint.pprint(list);
		
		System.out.println(list.getFirst() + " : " + list.element() + " : " + list.peek());
		System.out.println(list.getLast());
		list.addFirst(1);
		list.removeFirst();//remove()、poll()、pop();
		list.addLast(1);//add()、offer()、push();
		list.removeLast();
	}
	
	public static void set(){
		HashSet<Integer> set = new HashSet<>();
		Collections.addAll(set, 1, 2, 3, 4, 5);
		PPrint.pprint(set);
		
		HashSet<Integer> set2 = new HashSet<>();
		Collections.addAll(set2, 2, 3, 4);
		
		set.retainAll(set2);
		PPrint.pprint(set);
		
		Collections.addAll(set, 1, 5);
		
		PPrint.pprint(set);
		set.removeAll(set2);
		PPrint.pprint(set);
	}
	
	public static void map(){
		HashMap<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		map.put("ddd", "444");
		map.put("eee", "555");
		
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entrys.iterator();
		
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.print(entry.getKey());
			System.out.println(" " + entry.getValue() + " " );
			it.remove();
		}
		System.out.println(entrys);
		
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		map.put("ddd", "444");
		map.put("eee", "555");
		if(map.containsKey("aaa")){
			System.out.println(map.get("aaa"));
		}
		if(map.containsValue("111")){
			System.out.println(getValue(map, "111"));
		}
	}
	
	public static void queue(){
		PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
		
		Collections.addAll(queue, 4, 2, 5, 6, 9, 1, 3, 7);
		
		for(Integer elem : queue){
			System.out.println(elem);
		}
		PPrint.pprint(queue);

		while(queue.size()>0){
			System.out.println(queue.poll());
		}
	}
	
	public static String getValue(HashMap<String, String> map, String value) {
		for(Map.Entry<String, String> entry : map.entrySet()){
			if (entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		
		return "";
	}
}
