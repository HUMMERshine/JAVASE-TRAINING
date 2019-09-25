import java.util.HashMap;

/**
 * Created by lishutao on 2018/6/15.
 *
 * @author lishutao
 * @date 2018/6/15
 */
public class leetcodeTest {
    public static void main(String[] args) throws Exception {
        Integer result = new leetcodeTest().go("abba");
        System.out.println(result);
    }

    public Integer go(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int max = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }

}
