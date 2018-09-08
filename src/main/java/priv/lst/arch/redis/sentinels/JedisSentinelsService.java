package priv.lst.arch.redis.sentinels;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lishutao on 2018/8/16.
 *
 * @author lishutao
 * @date 2018/8/16
 */
public class JedisSentinelsService {

    private static JedisSentinelPool pool = null;

    public static void init() {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大阻塞时间，记住是毫秒数milliseconds
        config.setMaxWaitMillis(2000);
        // 设置空间连接
        config.setMaxIdle(5);
        // jedis实例是否可用
        boolean borrow = true;
        config.setTestOnBorrow(borrow);
        // 创建连接池
//      pool = new JedisPool(config, prop.getProperty("ADDR"), StringUtil.nullToInteger(prop.getProperty("PORT")), StringUtil.nullToInteger(prop.getProperty("TIMEOUT")));// 线程数量限制，IP地址，端口，超时时间
        //获取redis密码
//        String password = "test";

        String masterName = "mymaster";
        Set<String> sentinels = new HashSet<String>();
        sentinels.add("127.0.0.1:26000");
        sentinels.add("127.0.0.1:26001");
        sentinels.add("127.0.0.1:26002");
        pool = new JedisSentinelPool(masterName, sentinels, config);
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (pool == null) {
            init();
        }
    }

    /**
     * 获取一个jedis 对象
     *
     * @return
     */
    public static Jedis getJedis() {
        if (pool == null)
            poolInit();
        return pool.getResource();
    }

    /**
     * 释放一个连接
     *
     * @param jedis
     */
    public static void returnRes(Jedis jedis) {
//        pool.returnResource(jedis);
        pool.close();
    }

    /**
     * 销毁一个连接
     *
     * @param jedis
     */
    public static void returnBrokenRes(Jedis jedis) {
        pool.returnBrokenResource(jedis);
    }

}
