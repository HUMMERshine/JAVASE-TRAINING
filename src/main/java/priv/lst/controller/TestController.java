package priv.lst.controller;

import net.sf.ehcache.Element;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import priv.lst.ehcache.MyEhcache;
import priv.lst.ehcache.User;
import priv.lst.netty.NettyTest;
import priv.lst.schedule.ScheduleConfig;
import priv.lst.schedule.ScheduledDemo;
import priv.lst.spring.ApplicationContextDemo;
import priv.lst.spring.PostProcessor;
import priv.lst.spring.SpringBeanDemo;

/**
 * Created by lishutao on 2018/5/13.
 *
 * @author lishutao
 * @date 2018/5/13
 */
@RestController
public class TestController {

    @Autowired
    NettyTest nettyTest;

    @Autowired
    SpringBeanDemo springBeanDemo;

//    @Autowired
//    PostProcessor  postProcessor;

    @Autowired
    MyEhcache myEhcache;

    @RequestMapping("/helloworld")
    public String helloworld() {
        nettyTest.init();
        return "helloworld";
    }

    @RequestMapping("/sendMsg")
    public void sendMsg(@RequestParam("msg") String msg) {
        nettyTest.sendMsg(msg);

    }

    @RequestMapping("/ehcache")
    public String ehcache() {
        Element e = myEhcache.test();
        return e.toString();
    }

    @RequestMapping("/schedule")
    public ScheduleConfig schedule() {
        ScheduleConfig scheduleConfig =(ScheduleConfig) ApplicationContextDemo.getBean("scheduleConfig");
        return scheduleConfig;
    }
}