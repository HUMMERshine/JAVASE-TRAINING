package priv.lst.java8;

import javassist.expr.Instanceof;
import net.mindview.util.Pair;
import priv.lst.domain.Person;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by lishutao on 2018/6/22.
 *
 * @author lishutao
 * @date 2018/6/22
 */
public class UserStream {

    Print print = new Print();

    public static void main(String[] args) {

        new Thread(() -> System.out.println("hello world!"));

        new TreeSet<Integer>((x, y) -> x - y);

        new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        new Thread(() -> {
            System.out.println("hello world!");
        });

        List<String> features = Arrays.asList("Lambdas", "Default Method",
            "Stream API", "Date and Time API");

        features.stream().forEach(n -> System.out.println(n));
        features.stream().forEach(System.out :: println);
        features.stream().forEach(Print::print);

        List<String> filtered = features.stream().filter(x -> x.length()> 2)
            .collect(Collectors.toList());

        Set<String> set = features.stream().filter(x -> x.length()> 2)
            .collect(Collectors.toSet());

        List<Person> lists = new ArrayList<>();
        lists.add(new Person(1, "tom"));
        lists.add(new Person(2, "green"));
        lists.add(new Person(3, "jim"));

        //这种方式的key，value不可以为空，并且如果不加（old，newvalue）的话无法处理key相同的事情
        Map<Integer, String> map = lists.stream().collect(Collectors.toMap(Person::getId, Person::getName));

        lists.add(new Person(3, "karry"));
        Map<Integer, String> map2 = lists.stream().collect(Collectors.toMap(Person::getId, Person::getName, (oldvalue, newvalue) -> oldvalue + ", " + newvalue));

        HashMap<Integer, String> map3 = lists.stream().collect(Collectors.toMap(Person::getId, Person::getName, (oldvalue, newvalue) -> oldvalue + ", " + newvalue, LinkedHashMap::new));

        String filtered1 = features.stream().filter(x -> x.length()> 2)
            .collect(Collectors.joining(", "));

        System.out.println(map.getClass().getName() + map);
        System.out.println(map2.getClass().getName() + map2);
        System.out.println(map3.getClass().getName() + map3);

    }

    public static class Print {
        public static void print(String s) {
            System.out.println("hello!");
        }
    }


}
