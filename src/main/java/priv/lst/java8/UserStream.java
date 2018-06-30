package priv.lst.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.Callable;
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

        String filtered1 = features.stream().filter(x -> x.length()> 2)
            .collect(Collectors.joining(", "));

    }

    public static class Print {
        public static void print(String s) {
            System.out.println("hello!");
        }
    }


}
