package priv.lst;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import priv.lst.log4j.LogTest;
import priv.lst.netty.client.NettyClient;
import priv.lst.netty.server.NettyServer;

/**
 该注解指定项目为springboot，由此类当作程序入口
 自动装配 web 依赖的环境

 **/
@SpringBootApplication
public class AP {
    public static Logger LOGGER = LoggerFactory.getLogger(AP.class);
    public static void main(String[] args) {
        SpringApplication.run(AP.class, args);
        LOGGER.info("this is info");
        LOGGER.debug("this is debug");
        LOGGER.warn("this is warn");
        LOGGER.error("this is error");
        LOGGER.info("end");

    }

}
