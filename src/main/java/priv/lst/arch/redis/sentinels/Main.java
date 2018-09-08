package priv.lst.arch.redis.sentinels;

import redis.clients.jedis.Jedis;

/**
 * Created by lishutao on 2018/8/18.
 *
 * @author lishutao
 * @date 2018/8/18
 */
public class Main {
    private static String key;

    public static void main(String[] args) {
        key = "lishutao";
        Jedis jedis = JedisSentinelsService.getJedis();
        try {
            jedis.set(key, "list");
            String oldValue = jedis.get(key);
            jedis.getSet(key, "hello");
            String newValue = jedis.get(key);
            System.out.println("oldValue : " + oldValue);
            System.out.println("newValue : " + newValue);
        } catch (Exception ex) {
            JedisSentinelsService.returnBrokenRes(jedis);
        } finally {
            JedisSentinelsService.returnRes(jedis);
        }
    }
}
