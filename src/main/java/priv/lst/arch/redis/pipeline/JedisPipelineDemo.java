package priv.lst.arch.redis.pipeline;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by lishutao on 2018/8/3.
 *
 * @author lishutao
 * @date 2018/8/3
 */
public class JedisPipelineDemo {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost");

        JedisPipelineExecutor redisBatchExector = new JedisPipelineExecutor(jedisPool);

        redisBatchExector.open();

        redisBatchExector.set("we", "class01");

        redisBatchExector.lpush("list", "hello", "world", "are", "you", "ok");

//        redisBatchExector.broken();
        redisBatchExector.close();

    }
}
