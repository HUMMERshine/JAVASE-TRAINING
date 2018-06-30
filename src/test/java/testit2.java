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
}
