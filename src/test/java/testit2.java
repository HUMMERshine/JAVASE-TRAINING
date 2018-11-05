import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;
import priv.lst.domain.Student;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by lishutao on 2018/6/15.
 *
 * @author lishutao
 * @date 2018/6/15
 */
public class testit2 {
    public static void main(String[] args) {

        String str = "perf3sentinel";
        int start = 6134;
        int end = 6166;
        String result = "";
        for (int i = start; i <= end; i++) {
            result = result + str + i + "|";
        }

        result = result.substring(0, result.length() - 1);

        System.out.println(result);
    }

    @Test
    public void test1() {
        BigDecimal bigDecimal = BigDecimal.valueOf(10);
        bigDecimal = bigDecimal.setScale(2,BigDecimal.ROUND_DOWN);
        System.out.println(bigDecimal.compareTo(BigDecimal.valueOf(10.000)));

        String strs = "2";
        String [] ids = strs.split(",");
        List<String> list = Lists.newArrayList();
        for (String id : ids) {
            System.out.println(Integer.valueOf(id));
        }

        Set<Integer> set = Sets.newHashSet(1, 209);
        Integer x = 209;
        Integer y = 209;
        System.out.println(set);
        System.out.println(set.contains(y));
        System.out.println(set.contains(x));
        System.out.println(x.hashCode() + " " + y.hashCode());
        System.out.println(x.equals(y));

        Student student = new Student(1,"xxx");
        System.out.println(student.getId());

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
    }
}
