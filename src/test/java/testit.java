
import com.google.common.collect.Lists;
import javassist.bytecode.ByteArray;
import org.junit.Test;
import priv.lst.arch.test.MillisecondClock;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lishutao on 2018/6/15.
 *
 * @author lishutao
 * @date 2018/6/15
 */
public class testit {
    public static void main(String[] args) {


        String test = "JDDev6101,JDDev6102,JDDev6103,JDDev6104,JDDev6105,JDDev6106,JDDev6107,JDDev6108";

        test = test.replace(";", "|");

        test = test.replace(",", "|");
        test = test.replace("\n", ",");

        System.out.println(test);
        System.out.println("\0");
        char a = '\0';
        System.out.println(a + " " + Integer.valueOf(a));
        System.out.println('a' + " " + Integer.valueOf('a'));
        System.out.println("\\0");
//        System.out.println(hosts.replace("\n", ",\n"));
    }


    @Test
    public void test1 () {
        String test = "10.196.32.25:6101,10.196.32.25:6102,10.196.32.25:6103,10.196.32.25:6104,10.196.32.25:6105,10.196.32.25:6106,10.196.32.25:6107,10.196.32.25:6108";

        test = test.replace(";", "|");

        test = test.replace(",", "|");

        System.out.println(test);

        List<String> a = null;
        for (String s : a) {
            System.out.println(s);
        }
        List as = null;
        for (Object o : as) {

        }
    }

    @Test
    public void test2() {
        String test = "10.196.32.25";

        StringBuilder sb = new StringBuilder();
        for (int i = 6101; i <= 6108; i++) {
            sb.append(test).append(":").append(i).append(",");
        }
        System.out.println(sb.toString());
        test = test.replace(";", "|");

        test = test.replace(",", ";");

        System.out.println(test);
    }

    @Test
    public void test3() {
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        String test = "012345678910111213141516171819202122232425262728293031323334353637383940414243444546474849505152535455565758596061626364";
        String test2 = "国际物流邮件类测试";

        System.out.println(test.split(",").length);
        System.out.println(test.length());
        System.out.println(test2.length());
    }

    @Test
    public void test4() {
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        String test = "28.8";

        System.out.println(test.toCharArray());
        byte[] bytes = new byte[test.toCharArray().length];

        for (int i = 0; i < test.toCharArray().length; i++) {
            bytes[i] = (byte)test.toCharArray()[i];
        }

        System.out.println(Arrays.toString("28.8".getBytes()));

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(test.toCharArray()));

        double d = 3.99;
        System.out.println(String.valueOf(d));

        int x = 100;
        byte y = (byte)x;
        System.out.println(x + " " + y);
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toHexString(y));

        long l = 128;
        System.out.println(l & 0xff);
        System.out.println(l & 0xff);
        System.out.println(l & 0xff);
        System.out.println(l & 0xff);
        System.out.println(l & 0xff);
        System.out.println(l & 0xff);
        System.out.println(l & 0xff);

    }

    @Test
    public void test5() throws InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 5, 5, TimeUnit.SECONDS);

        Thread.sleep(60 * 1000);
    }

}
