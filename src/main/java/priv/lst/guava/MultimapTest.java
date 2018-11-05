package priv.lst.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import java.util.Collection;
import java.util.Map;

/**
 * Created by lishutao on 2018/10/26.
 *
 * @author lishutao
 * @date 2018/10/26
 */
public class MultimapTest {
    class Student {
        String name;
        int age;
    }

    private static final String CLASS_NAME_1 = "一年级";
    private static final String CLASS_NAME_2 = "二年级";

    Multimap<String, Student> multimap = ArrayListMultimap.create();

    public void testStudent() {

        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.name = "Tom" + i;
            student.age = 6;
            multimap.put(CLASS_NAME_1, student);
        }
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.name = "Jary" + i;
            student.age = 7;
            multimap.put(CLASS_NAME_2, student);
        }

        for (Student stu : multimap.get(CLASS_NAME_1)) {
            System.out.println("一年级学生 name:" + stu.name + " age:" + stu.age);
        }
        //判断键是否存在
        if(multimap.containsKey(CLASS_NAME_1)){
            System.out.println("键值包含："+CLASS_NAME_1);
        }
        //”键-单个值映射”的个数
        System.out.println(multimap.size());
        //不同键的个数
        System.out.println(multimap.keySet().size());

        Map<String, Collection<Student>> collectionMap = multimap.asMap();
//        Map<String, Collection<Student>> collectionMap = Multimaps.asMap(multimap);
        System.out.println(multimap.size() + " " + collectionMap.size());
        System.out.println(multimap.entries().size() + " " + collectionMap.entrySet().size());
        System.out.println(multimap.values() + " " + collectionMap.values());
        System.out.println(multimap.values().size() + " " + collectionMap.values().size());
    }

    public static void main(String[] args) {
        MultimapTest multimapTest = new MultimapTest();
        multimapTest.testStudent();
    }
}
