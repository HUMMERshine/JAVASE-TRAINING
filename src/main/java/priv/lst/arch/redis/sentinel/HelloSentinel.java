package main.java.priv.lst.arch.redis.sentinel;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lishutao on 2018/7/2.
 *
 * @author lishutao
 * @date 2018/7/2
 */
public class HelloSentinel {
    public static void main(String[] args) {
        Set<String> sentinels = new HashSet<>(Arrays.asList("127.0.0.1:6370", "127.0.0.1:6371", "127.0.0.1:6372"));
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

    }
}
