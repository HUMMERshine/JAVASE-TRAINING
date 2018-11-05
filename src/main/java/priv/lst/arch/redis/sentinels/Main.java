package priv.lst.arch.redis.sentinels;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

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
//            JedisSentinelsService.returnRes(jedis);
        }

//        jedis.get("lishutao");
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 10000; i++) {
            pipeline.set("count", String.valueOf(i));
        }
//        pipeline.sync();
        List<String> result = (List<String>)(List)(pipeline.syncAndReturnAll());
        System.out.println(jedis.get("count"));
        System.out.println(result.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(result.get(i));
        }
    }
}
