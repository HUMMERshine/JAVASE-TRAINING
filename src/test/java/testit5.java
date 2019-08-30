
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
/**
 * Created by lishutao on 2018/6/15.
 *
 * @author lishutao
 * @date 2018/6/15
 */
public class testit5 {

    @Test
    public void date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String dayKey = dateFormat.format(new Date());

        System.out.println(dayKey);
    }

}
