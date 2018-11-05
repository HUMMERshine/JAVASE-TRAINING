import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;
import priv.lst.arch.test.MillisecondClock;
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

    @Test
    public void test3() throws InterruptedException, Exception {
        System.out.println(MillisecondClock.CLOCK.now());
        Thread.sleep(1000);
        System.out.println(MillisecondClock.CLOCK.now());
        MillisecondClock.CLOCK.t.interrupt();
        Thread.sleep(10000);
        System.out.println(MillisecondClock.CLOCK.now());
    }

    @Test
    public <T> void test4() {
        String group = "1001";
        System.out.println(group);
        System.out.println(group + "\0");
        char ch = '\0';
        System.out.println(ch);
        System.out.println("1");
        int chi = '1';
        int ch0 = '\0';
        System.out.println(chi);
        System.out.println(ch0);
        System.out.println('1' - '\0');

        String x = String.class.cast("123");
        System.out.println(x);

        int y = 1;
        System.out.printf("%x, %d\n", y, y);
        y = 0x22;
        System.out.printf("%x, %d\n", y, y);
    }

}
