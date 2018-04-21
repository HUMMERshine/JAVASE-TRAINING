package priv.lst.thinkinjava;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 *  SimpleDateFormat函数语法：
  G 年代标志符
  y 年
  M 月
  d 日
  h 时 在上午或下午 (1~12)
  H 时 在一天中 (0~23)
  m 分
  s 秒
  S 毫秒
  E 星期
  D 一年中的第几天
  F 一月中第几个星期几
  w 一年中第几个星期
  W 一月中第几个星期
  a 上午 / 下午 标记符 
  k 时 在一天中 (1~24)
  K 时 在上午或下午 (0~11)
  z 时区
 */
public class SimpleDataFormatTraining {
	public static void main(String[] args) {
		SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyy年MM月dd日HH时mm分ss秒 E");
		System.out.println(sdfmt1.format(new Date()));
		SimpleDateFormat sdfmt2 = new SimpleDateFormat("yy/MM/dd HH:mm");
		System.out.println(sdfmt2.format(new Date()));
		SimpleDateFormat sdfmt3=new SimpleDateFormat(
                "一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
		System.out.println(sdfmt3.format(new Date()));
	}
}
