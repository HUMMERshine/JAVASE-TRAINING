package priv.lst.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by lishutao on 2019-09-20.
 *
 * @author lishutao
 * @date 2019-09-20
 */
@Service
public class ScheduledDemo {

    public static int i = 0;

    @Scheduled(cron = "0/5 * * * * ?")
    public void testA() {
        System.out.println("testA " + Thread.currentThread());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void testB() throws InterruptedException {
        System.out.println("testB " + Thread.currentThread());
        i++;
        if (i > 5) {
            throw new RuntimeException("error");
        }
        Thread.sleep(1000 * 100);
    }
}
