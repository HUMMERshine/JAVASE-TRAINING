
import org.junit.Test;

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
//        System.out.println(hosts.replace("\n", ",\n"));
    }


    @Test
    public void test1 () {
        String test = "10.196.32.25:6101,10.196.32.25:6102,10.196.32.25:6103,10.196.32.25:6104,10.196.32.25:6105,10.196.32.25:6106,10.196.32.25:6107,10.196.32.25:6108";

        test = test.replace(";", "|");

        test = test.replace(",", "|");

        System.out.println(test);
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
}
