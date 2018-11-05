package priv.lst.arch.test;

/**
 * Created by hzzhanghongxiao on 2018/10/29.
 *
 * @author hzzhanghongxiao
 * @date 2018/10/29
 */
public class MillisecondClock {
    private long rate = 0;// 频率
    private volatile long now = 0;// 当前时间
    private boolean alive = true;
    public Thread t;

    private MillisecondClock(long rate) {
        this.rate = rate;
        this.now = System.currentTimeMillis();
        start();
    }

    private void start() {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(rate);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        alive = false;
                        System.out.println(Thread.currentThread().isInterrupted());
                        Thread.currentThread().interrupt();
                        System.out.println(Thread.currentThread().isInterrupted());
                    }
                    now = System.currentTimeMillis();
                }
            }
        });
        t.start();
    }

    public long now() throws Exception {
        if (!alive) {
            throw new Exception("MillisecondClock shutdown");
        }
        return now;
    }

    public static final MillisecondClock CLOCK = new MillisecondClock(10);
}
