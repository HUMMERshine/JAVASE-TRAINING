package priv.lst.java;

/**
 * Created by lishutao on 2019-09-17.
 *
 * @author lishutao
 * @date 2019-09-17
 */
public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal3 = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal4 = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal5 = new ThreadLocal<>();
        threadLocal1.set(101);
        threadLocal1.get();
        threadLocal2.set(102);
        threadLocal2.get();
        threadLocal3.set(103);
        threadLocal3.get();
        threadLocal4.set(104);
        threadLocal4.get();
        threadLocal5.set(105);
        threadLocal5.get();

        Thread.sleep(Integer.MAX_VALUE);
    }
}
