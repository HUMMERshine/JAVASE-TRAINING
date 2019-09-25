package priv.lst;

import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

/**
 * Created by lishutao on 2019-09-12.
 *
 * @author lishutao
 * @date 2019-09-12
 */
public class IOStream {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/lishutao/logs/a.txt");
        FileInputStream fileInputStream  = new FileInputStream(file);

        String str = StreamUtils.copyToString(fileInputStream, Charset.defaultCharset());
        System.out.println(str);
    }
}
