package priv.lst.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lishutao on 2018/10/26.
 *
 * @author lishutao
 * @date 2018/10/26
 */
public class LogTest {
    public static Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        LOGGER.info("this is info");
        LOGGER.debug("this is debug");
        LOGGER.warn("this is warn");
        LOGGER.error("this is error");
        LOGGER.info("end");
    }
}
