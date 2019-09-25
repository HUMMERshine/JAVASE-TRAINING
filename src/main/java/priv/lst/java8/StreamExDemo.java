package priv.lst.java8;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import one.util.streamex.EntryStream;
import one.util.streamex.StreamEx;
import org.junit.Test;
import priv.lst.domain.Person;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by lishutao on 2018/6/22.
 *
 * @author lishutao
 * @date 2018/6/22
 */
public class StreamExDemo {

    private static List<Person> personList =
        Lists.newArrayList(new Person(1, "tom"), new Person(2, "green"), new Person(3, "jim"),
            new Person(3, "jim1"), new Person(3, "jim"));

    private static Map<Integer, Person> personMap = Maps.newHashMap();
    static {
        personMap.put(1, new Person(1, "tom"));
        personMap.put(2, new Person(2, "green"));
        personMap.put(3, new Person(3, "jim"));
//        personMap.put(1, new Person(1, "tom"));
    }

    public static void main(String[] args) {




    }

    @Test
    public void flatMap(){
        List<String> list = StreamEx.of(personList)
            .flatMap(person -> Arrays.stream(person.getName().split("")))
            .toList();

        System.out.println(list);
    }

    @Test
    public void GroupingBy(){
        Map<Integer, List<Person>> map = StreamEx.of(personList)
            .groupingBy(Person::getId);

        System.out.println(map);

        Map<Integer, Set<Person>> map1 = StreamEx.of(personList)
            .groupingBy(Person::getId, Collectors.toSet());

        System.out.println(map1);

        Map<Integer, List<String>> map2 = StreamEx.of(personList)
            .groupingBy(Person::getId, Collectors.mapping(Person::getName, Collectors.toList()));

        System.out.println(map2);

        Map<Integer, Set<String>> map3 = StreamEx.of(personList)
            .groupingBy(Person::getId, Collectors.mapping(Person::getName, Collectors.toSet()));

        System.out.println(map3);
    }

    @Test
    public void EntryStream(){
        List<Integer> keyList = EntryStream.of(personMap)
            .keys()
            .toList();

        System.out.println(keyList);

        List<Map.Entry<Integer , Person>> map = EntryStream.of(personMap)
            .flatMapToValue((a, b) -> Lists.newArrayList(b, b).stream())
            .toList();

        System.out.println(map);
    }
}
