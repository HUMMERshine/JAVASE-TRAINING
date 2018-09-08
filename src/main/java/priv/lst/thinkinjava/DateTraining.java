package priv.lst.thinkinjava;

import java.text.SimpleDateFormat;

/**
 * Created by lishutao on 2018/7/6.
 *
 * @author lishutao
 * @date 2018/7/6
 */
public class DateTraining {

    /**
     * java.util.Date 和 java.sql.Date 的区别：
     * https://www.cnblogs.com/jinxiuze/p/7977577.html
     * @param args
     */
    public static void main(String[] args) {
        java.util.Date utilDate = new java.util.Date();
        Long curTime = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(curTime);

        System.out.println("java.util.Date 的 getTime() : " + curTime);
        System.out.println("java.sql.Date 的 getTime() : " + sqlDate.getTime());

        System.out.println("java.util.Date 的 toString 字符串是 : " + utilDate);
        System.out.println("java.sql.Date 的 toString 字符串是 : " + sqlDate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd  hh:mm:ss");
        System.out.println("java.util.Date 的 format 字符串是 : " + simpleDateFormat.format(utilDate));
        System.out.println("java.sql.Date 的 format 字符串是 : " + simpleDateFormat.format(sqlDate));
    }
}
