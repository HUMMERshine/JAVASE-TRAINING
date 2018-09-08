package priv.lst.thinkinjava;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lishutao on 2018/8/10.
 *
 * @author lishutao
 * @date 2018/8/10
 */
public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() == 1) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
