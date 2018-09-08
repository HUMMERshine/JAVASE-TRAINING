package priv.lst.arch.redis.cluster;


import redis.clients.jedis.JedisCluster;

/**
 * Created by lishutao on 2018/7/21.
 *
 * @author lishutao
 * @date 2018/7/21
 */
public class Main {
    public static JedisClusterService getJedisClusterService() {
        JedisClusterService jedisClusterService = new JedisClusterService();
        jedisClusterService.init();

        return jedisClusterService;
    }

    public static void main(String[] args) {
        JedisClusterService jedisClusterService= getJedisClusterService();

        jedisClusterService.deleteWithPrefix(PREFIX_KEY, "hello1");
        jedisClusterService.setWithPrefix(PREFIX_KEY, "hello1", "world");
        jedisClusterService.existsWithPrefix(PREFIX_KEY, "hello1");
        jedisClusterService.getWithPrefix(PREFIX_KEY, "hello1");

    }

    private final static String PREFIX_KEY = "lishutao";
}
