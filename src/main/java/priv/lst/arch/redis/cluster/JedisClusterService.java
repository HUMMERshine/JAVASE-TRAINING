package priv.lst.arch.redis.cluster;

import com.sun.org.apache.xml.internal.security.Init;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lishutao on 2018/7/21.
 *
 * @author lishutao
 * @date 2018/7/21
 */
public class JedisClusterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JedisClusterService.class);

    private static final String REDIS_CACHE_CLUSTER_NODES = "127.0.0.1:7000,127.0.0.1:7001,127.0.0.1:7002,127.0.0.1:7003,127.0.0.1:7004,127.0.0.1:7005";
    private static final Integer REDIS_CACHE_COMMANDTIMEOUT = 1000;
    private static final Integer REDIS_CACHE_SOTIMEOUT = 1000;
    private static final Integer REDIS_CACHE_MAXATTEMPTS = 1000;
    private static final String REDIS_CACHE_CLUSTER_PASSWOR = "keyword";
    private static final String KEY_SPLIT = ",";

    JedisCluster jedisCluster = null;

    public void init() {
        String[] serverArray = REDIS_CACHE_CLUSTER_NODES.split(",");
        Set<HostAndPort> nodes = new HashSet<>();

        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMinIdle(1);
        jedisPoolConfig.setMaxWaitMillis(5000);
        jedisPoolConfig.setTestOnBorrow(true);

//        jedisCluster = new JedisCluster(nodes, REDIS_CACHE_COMMANDTIMEOUT, REDIS_CACHE_SOTIMEOUT,
//            REDIS_CACHE_MAXATTEMPTS, REDIS_CACHE_CLUSTER_PASSWOR, jedisPoolConfig);
        jedisCluster = new JedisCluster(nodes, REDIS_CACHE_COMMANDTIMEOUT, REDIS_CACHE_SOTIMEOUT,
            REDIS_CACHE_MAXATTEMPTS, jedisPoolConfig);
    }

    public JedisCluster getJedisCluster() {
        return this.jedisCluster;
    }

    public void setWithPrefix(String prefix, String key, String value) {
        if(StringUtils.isBlank(prefix)) throw new IllegalArgumentException("prefix must not null!");
        if(StringUtils.isBlank(key)) throw new IllegalArgumentException("key must not null!");

        String result = jedisCluster.set(prefix + KEY_SPLIT + key, value);
        LOGGER.debug("RedisUtil:{} :{ key={}; value={}; result={} }", Thread.currentThread().getStackTrace()[1].getMethodName(), prefix + KEY_SPLIT + key, value, result);
    }

    public String getWithPrefix(String prefix, String key) {
        if(StringUtils.isBlank(prefix)) throw new IllegalArgumentException("prefix must not null!");
        if(StringUtils.isBlank(key)) throw new IllegalArgumentException("key must not null!");

        String value = jedisCluster.get(prefix + KEY_SPLIT + key);
        LOGGER.debug("RedisUtil:{} :{ key={}; value={} }", Thread.currentThread().getStackTrace()[1].getMethodName(),  prefix + KEY_SPLIT + key, value);
        return value;
    }

    public boolean existsWithPrefix(String prefix, String key) {
        if(StringUtils.isBlank(prefix)) throw new IllegalArgumentException("prefix must not null!");
        if(StringUtils.isBlank(key)) throw new IllegalArgumentException("key must not null!");

        Boolean result = jedisCluster.exists(prefix + KEY_SPLIT + key);
        LOGGER.debug("RedisUtil:{} :{ key={}; result={} }", Thread.currentThread().getStackTrace()[1].getMethodName(), prefix + KEY_SPLIT + key, result);
        return result;
    }

    public void deleteWithPrefix(String prefix, String key){
        if(StringUtils.isBlank(prefix)) throw new IllegalArgumentException("prefix must not null!");
        if(StringUtils.isBlank(key)) throw new IllegalArgumentException("key must not null!");

        Long result = jedisCluster.del(prefix + KEY_SPLIT + key);
        LOGGER.debug("RedisUtil:{} :{ key={}; result={} }", Thread.currentThread().getStackTrace()[1].getMethodName(), prefix + KEY_SPLIT + key, result);
    }

}
